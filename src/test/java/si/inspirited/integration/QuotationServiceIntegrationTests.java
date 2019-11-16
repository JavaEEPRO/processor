package si.inspirited.integration;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.dto.QuotationDto;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IQuotationService;
import si.inspirited.util.IQuotationDaoToDtoConverter;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuotationServiceIntegrationTests {

    @Autowired
    IQuotationService quotationService;

    @Autowired
    IQuotationDaoToDtoConverter daoToDtoConverter;

    @Test
    public void addQuotation_whenReceivedListContainsIt_thenCorrect() {
        Quotation quotationToSave = getStubQuotation();
        QuotationDto quotationReturned = quotationService.addQuotation(quotationToSave);
        Long id = quotationReturned.getId();
        assertNotNull(quotationReturned);
        assertNotEquals(id, null);
        //quotationReturned.setId(null);
        assertEquals(daoToDtoConverter.getDto(quotationToSave), quotationReturned);
        Page<QuotationDto> receivedPage = quotationService.getTop5QuotationsOrderedByLatestPrice4LastOfThemByCompanyName();
        List<QuotationDto> receivedList = receivedPage.getContent();
        assertEquals(1, receivedList.size());
        QuotationDto quotationQueried = receivedList.get(0);
        //quotationQueried.setId(null);
        assertEquals(daoToDtoConverter.getDto(quotationToSave), quotationQueried);
    }

    @Test
    public void addDozenQuotations_whenReceivedListHasOnlyTopFiveQuotationsOrderedByChangePercent_thenCorrect() {
        List<Quotation> quotationsBeenAdded = addAndGetDozenOfQuotation();
        Page<QuotationDto> quotationsBeenQueried = quotationService.getTop5QuotationsOrderedByChangePercent();
        assertEquals(5, quotationsBeenQueried.getContent().size());
        List<QuotationDto> listQuotationsBeenQueried = quotationsBeenQueried.getContent();
        for (int i = 0; i < listQuotationsBeenQueried.size() - 1; i++) {
            Double thisQuotationChangePercent = listQuotationsBeenQueried.get( i ).getChangePercent();
            Double nextQuotationChangePercent = listQuotationsBeenQueried.get( i + 1 ).getChangePercent();
            assertTrue(thisQuotationChangePercent < nextQuotationChangePercent);
        }
        assertTrue(listQuotationsBeenQueried.stream().max(Comparator.comparingDouble(QuotationDto::getChangePercent)).get().getChangePercent() <= quotationsBeenAdded.stream().max(Comparator.comparingDouble(Quotation::getChangePercent)).get().getChangePercent());
    }

    @Test
    public void addDozenQuotations_whenReceivedPageHasOnlyTopFiveOrderedByLatestPrice4LastOfThemByCompanyName_thenCorrect() {
        List<Quotation> quotationsBeenAdded = addAndGetDozenOfQuotation();
        Page<QuotationDto> quotationsBeenQueried = quotationService.getTop5QuotationsOrderedByLatestPrice4LastOfThemByCompanyName();
        assertEquals(5, quotationsBeenQueried.getContent().size());
        List<QuotationDto> listQuotationsBeenQueried = quotationsBeenQueried.getContent();
        // 1. first Quotation should have max value
        QuotationDto firstQuotation = listQuotationsBeenQueried.get(0);
        Double firstQuotationLatestPriceExpectedToBeTheHighest = firstQuotation.getLatestPrice();
            // 1.1 among others in queried list
        for (int i = 1; i < listQuotationsBeenQueried.size() - 1; i++) {
            Double thisQuotationLatestPrice = listQuotationsBeenQueried.get( i ).getLatestPrice();
            assertTrue(thisQuotationLatestPrice < firstQuotationLatestPriceExpectedToBeTheHighest);
        }
            // 1.2 among all in full list, that was added
        for (int i = 0; i < quotationsBeenAdded.size(); i++) {
            Double thisQuotationLatestPrice = quotationsBeenAdded.get( i ).getLatestPrice();
            assertTrue(thisQuotationLatestPrice <= firstQuotationLatestPriceExpectedToBeTheHighest);
        }
        // 2. four last Quotations should be sorted by companyName
        for (int i = 1; i < listQuotationsBeenQueried.size() - 1; i++) {
            QuotationDto thisQuotation = listQuotationsBeenQueried.get(i);
            QuotationDto nextQuotation = listQuotationsBeenQueried.get(i + 1);
            assertTrue(thisQuotation.getCompanyName().compareTo(nextQuotation.getCompanyName()) <= 0);
        }
        //assertTrue(listQuotationsBeenQueried.stream().min(Comparator.comparingDouble(QuotationDto::getLatestPrice)).get().getLatestPrice() >= quotationsBeenAdded.stream().min(Comparator.comparingDouble(Quotation::getLatestPrice)).get().getLatestPrice());
    }

    @After
    public void refreshQuotationStorage() {
        quotationService.refreshQuotationStorage();
    }

    //
    private List<Quotation> addAndGetDozenOfQuotation() {
        List<Quotation> res = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            Quotation nextQuotation = getStubQuotation();
            Random random = new Random();
            Double latestPrice = nextQuotation.getLatestPrice() * random.nextDouble();
            Double changePercent = nextQuotation.getChangePercent() * random.nextDouble();
            String companyName = nextQuotation.getCompanyName().substring(i);
            nextQuotation.setLatestPrice(latestPrice);
            nextQuotation.setChangePercent(changePercent);
            nextQuotation.setCompanyName(companyName);
            QuotationDto nextQuotationDto = quotationService.addQuotation(nextQuotation);
            nextQuotation.setId(nextQuotationDto.getId());
            res.add(nextQuotation);
        }
        return res;
    }

    private Quotation getStubQuotation() {
        Quotation res = new Quotation();
        res.setSymbol("PRFCT");
        res.setCompanyName("MicrosouthAlpha");
        res.setPrimaryExchange("PREX");
        res.setCalculationPrice("highest");
        res.setOpen("any time");
        res.setOpenTime(LocalTime.of(01,02, 03, 003));
        res.setLatestPrice(213.731);
        res.setChangePercent(-0.0007);
        return res;
    }
}
