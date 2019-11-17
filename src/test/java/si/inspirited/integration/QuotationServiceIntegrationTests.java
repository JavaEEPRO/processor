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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
        assertNotNull(id);
        //quotationReturned.setId(null);
        assertEquals(daoToDtoConverter.getDto(quotationToSave), quotationReturned);
        Page<QuotationDto> receivedPage = quotationService.getTop5QuotationsOrderedByVolume4LastOfThemByCompanyName();
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
            assertTrue(thisQuotationChangePercent > nextQuotationChangePercent);
        }
        assertTrue(listQuotationsBeenQueried.stream().max(Comparator.comparingDouble(QuotationDto::getChangePercent)).get().getChangePercent() >= quotationsBeenAdded.stream().max(Comparator.comparingDouble(Quotation::getChangePercent)).get().getChangePercent());
    }

    @Test
    public void addDozenQuotations_whenReceivedPageHasOnlyTopFiveOrderedByValue4LastOfThemByCompanyName_thenCorrect() {
        List<Quotation> quotationsBeenAdded = addAndGetDozenOfQuotation();
        Page<QuotationDto> quotationsBeenQueried = quotationService.getTop5QuotationsOrderedByVolume4LastOfThemByCompanyName();
        assertEquals(5, quotationsBeenQueried.getContent().size());
        List<QuotationDto> listQuotationsBeenQueried = quotationsBeenQueried.getContent();
        // 1. first Quotation should have max volume
        QuotationDto firstQuotation = listQuotationsBeenQueried.get(0);
        Integer firstQuotationVolumeExpectedToBeTheHighest = firstQuotation.getVolume();
            // 1.1 among others in queried list
        for (int i = 1; i < listQuotationsBeenQueried.size() - 1; i++) {
            Integer thisQuotationVolume = listQuotationsBeenQueried.get( i ).getVolume();
            assertTrue(thisQuotationVolume < firstQuotationVolumeExpectedToBeTheHighest);
        }
            // 1.2 among all in full list, that was added
        for (int i = 0; i < quotationsBeenAdded.size(); i++) {
            Integer thisQuotationVolume = quotationsBeenAdded.get( i ).getVolume();
            assertTrue(thisQuotationVolume <= firstQuotationVolumeExpectedToBeTheHighest);
        }
        // 2. four last Quotations should be sorted by companyName
        for (int i = 1; i < listQuotationsBeenQueried.size() - 1; i++) {
            QuotationDto thisQuotation = listQuotationsBeenQueried.get(i);
            QuotationDto nextQuotation = listQuotationsBeenQueried.get(i + 1);
            assertTrue(thisQuotation.getCompanyName().compareTo(nextQuotation.getCompanyName()) <= 0);
        }
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
            Integer volume = nextQuotation.getVolume() * random.nextInt();
            String companyName = nextQuotation.getCompanyName().substring(i);
            nextQuotation.setLatestPrice(latestPrice);
            nextQuotation.setChangePercent(changePercent);
            nextQuotation.setCompanyName(companyName);
            nextQuotation.setVolume(volume);
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
        //res.setOpen("any time");
        res.setOpenTime(1375632L);
        res.setLatestPrice(213.731);
        res.setChangePercent(-0.0007);
        res.setVolume(98765);
        return res;
    }
}
