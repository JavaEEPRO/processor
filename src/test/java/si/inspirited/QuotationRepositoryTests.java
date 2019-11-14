package si.inspirited;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationRepositoryTests {

    @Autowired
    QuotationRepository quotationRepository;

    @Test
    public void pushQuotationToRepo_ifCouldFindItStored_thenCorrect() {
        Quotation quotationForPush = getStubQuotation();
        Quotation returnedQuotation = quotationRepository.save(quotationForPush);
        assertNotNull(returnedQuotation);
        Long id = returnedQuotation.getId();
        assertNotNull(id);
        returnedQuotation.setId(null);
        assertEquals(quotationForPush, returnedQuotation);
        Quotation queriedFromRepoQuotation = quotationRepository.getOne(id);
        assertEquals(id, queriedFromRepoQuotation.getId());
    }

    @Test
    public void pushDozenQuotationsToRepo_whenCouldQueryThemSortedByLatestPrice_thenCorrect() {
        List<Quotation> quotationsBeenPushed = storeAndGetCoupleQuotations();
        List<Quotation> quotationsBeenQueried = quotationRepository.findTopOrderedByLatestPrice();
        assertEquals(quotationsBeenPushed.size(), quotationsBeenQueried.size());
        for (int i = 0; i < quotationsBeenQueried.size() - 1; i++) {
            Double thisQuotationLatestPrice = quotationsBeenQueried.get( i ).getLatestPrice();
            Double nextQuotationLatestPrice = quotationsBeenQueried.get( i + 1 ).getLatestPrice();
            assertTrue(thisQuotationLatestPrice > nextQuotationLatestPrice);
        }
    }

    @Test
    public void pushDozenQuotationsToRepo_whenCouldQueryThemSortedDescendingByChangePercent_thenCorrect() {
        List<Quotation> quotationsBeenPushed = storeAndGetCoupleQuotations();
        List<Quotation> quotationsBeenQueried = quotationRepository.findLastOrderedDescByChangePercent();
        assertEquals(quotationsBeenPushed.size(), quotationsBeenQueried.size());
        for (int i = 0; i < quotationsBeenQueried.size() - 1; i++) {
            Double thisQuotationLatestPrice = quotationsBeenQueried.get( i ).getChangePercent();
            Double nextQuotationLatestPrice = quotationsBeenQueried.get( i + 1 ).getChangePercent();
            assertTrue(thisQuotationLatestPrice < nextQuotationLatestPrice);
        }
    }

    @After
    public void refreshQuotationStorage() {
        quotationRepository.deleteAll();
    }

    //
    private List<Quotation> storeAndGetCoupleQuotations() {
        List<Quotation> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Quotation nextQuotation = getStubQuotation();
            Random random = new Random();
            Double latestPrice = nextQuotation.getLatestPrice() * random.nextDouble();
            Double changePercent = nextQuotation.getChangePercent() * random.nextDouble();
            nextQuotation.setLatestPrice(latestPrice);
            nextQuotation.setChangePercent(changePercent);
            nextQuotation = quotationRepository.save(nextQuotation);
            res.add(nextQuotation);
        }
        return res;
    }

    private Quotation getStubQuotation() {
        Quotation res = new Quotation();
        res.setSymbol("MRCY");
        res.setCompanyName("Microsauce");
        res.setPrimaryExchange("PARAUS");
        res.setCalculationPrice("rise");
        res.setOpen("of course");
        res.setOpenTime(LocalTime.of(11,12));
        res.setLatestPrice(352.347);
        res.setChangePercent(-0.0004);
        return res;
    }
}
