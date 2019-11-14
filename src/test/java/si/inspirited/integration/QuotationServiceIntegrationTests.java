package si.inspirited.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IQuotationService;

import java.time.LocalTime;
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

    @Test
    public void addQuotation_whenReceivedListContainsIt_thenCorrect() {
        Quotation quotationToSave = getStubQuotation();
        Quotation quotationReturned = quotationService.addQuotation(quotationToSave);
        Long id = quotationReturned.getId();
        assertNotNull(quotationReturned);
        assertNotEquals(id, null);
        quotationReturned.setId(null);
        assertEquals(quotationToSave, quotationReturned);
        List<Quotation> receivedList = quotationService.getTop5QuotationsOrderedByLatestPrice();
        assertEquals(1, receivedList.size());
        Quotation quotationQueried = receivedList.get(0);
        quotationQueried.setId(null);
        assertEquals(quotationToSave, quotationQueried);
    }

    @Test
    public void addDozenQuotations_whenReceivedListHasOnlyLastFiveQuotationsOrderedByChangePercentDesc_thenCorrect() {
        List<Quotation> quotationsBeenAdded = addAndGetDozenOfQuotation();
        Page<Quotation> quotationsBeenQueried = quotationService.getLast5QuotationsOrderedDescByChangePercent();
        assertEquals(5, quotationsBeenQueried.getContent().size());
        List<Quotation> listQuotationsBeenQueried = quotationsBeenQueried.getContent();
        for (int i = 0; i < listQuotationsBeenQueried.size() - 1; i++) {
            Double thisQuotationLatestPrice = listQuotationsBeenQueried.get( i ).getChangePercent();
            Double nextQuotationLatestPrice = listQuotationsBeenQueried.get( i + 1 ).getChangePercent();
            assertTrue(thisQuotationLatestPrice < nextQuotationLatestPrice);
        }
        assertTrue(listQuotationsBeenQueried.stream().max(Comparator.comparingDouble(Quotation::getChangePercent)).get().getChangePercent() <= quotationsBeenAdded.stream().max(Comparator.comparingDouble(Quotation::getChangePercent)).get().getChangePercent());
    }

    //
    private List<Quotation> addAndGetDozenOfQuotation() {
        List<Quotation> res = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            Quotation nextQuotation = getStubQuotation();
            Random random = new Random();
            Double latestPrice = nextQuotation.getLatestPrice() * random.nextDouble();
            Double changePercent = nextQuotation.getChangePercent() * random.nextDouble();
            nextQuotation.setLatestPrice(latestPrice);
            nextQuotation.setChangePercent(changePercent);
            nextQuotation = quotationService.addQuotation(nextQuotation);
            res.add(nextQuotation);
        }
        return res;
    }

    private Quotation getStubQuotation() {
        Quotation res = new Quotation();
        res.setSymbol("PRFCT");
        res.setCompanyName("Microsouth");
        res.setPrimaryExchange("PREX");
        res.setCalculationPrice("highest");
        res.setOpen("any time");
        res.setOpenTime(LocalTime.of(01,02, 03, 003));
        res.setLatestPrice(213.731);
        res.setChangePercent(-0.0007);
        return res;
    }
}
