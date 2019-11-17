package si.inspirited;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuotationRepositoryTests {

    @Autowired
    QuotationRepository quotationRepository;

    private final Integer DOZEN = 12;

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
    public void pushDozenQuotationsToRepo_whenCouldQueryThemSortedByVolume_thenCorrect() {
        List<Quotation> quotationsBeenPushed = storeAndGetCoupleQuotations();
        PageRequest pageRequest = PageRequest.of(0, DOZEN);
        Page<Quotation> pageQuotationsBeenQueried = quotationRepository.findTopOrderedByVolume(pageRequest);
        List<Quotation> quotationsBeenQueried = pageQuotationsBeenQueried.getContent();
        assertEquals(quotationsBeenPushed.size(), quotationsBeenQueried.size());
        for (int i = 0; i < quotationsBeenQueried.size() - 1; i++) {
            Integer thisQuotationVolume = quotationsBeenQueried.get( i ).getVolume();
            Integer nextQuotationVolume = quotationsBeenQueried.get( i + 1 ).getVolume();
            assertTrue(thisQuotationVolume > nextQuotationVolume);
        }
    }

    @Test
    public void pushDozenQuotationsToRepo_whenCouldQueryThemSortedByChangePercent_thenCorrect() {
        List<Quotation> quotationsBeenPushed = storeAndGetCoupleQuotations();
        PageRequest pageRequest = PageRequest.of(0, DOZEN);
        Page<Quotation> quotationsBeenQueried = quotationRepository.findTopOrderedByChangePercent(pageRequest);
        assertEquals(quotationsBeenPushed.size(), quotationsBeenQueried.getTotalElements());
        List<Quotation> listOfQuotationsBeenQueried = quotationsBeenQueried.getContent();
        for (int i = 0; i < quotationsBeenQueried.getTotalElements() - 1; i++) {
            Double thisQuotationLatestPrice = listOfQuotationsBeenQueried.get( i ).getChangePercent();
            Double nextQuotationLatestPrice = listOfQuotationsBeenQueried.get( i + 1 ).getChangePercent();
            assertTrue(thisQuotationLatestPrice > nextQuotationLatestPrice);
        }
    }

    @After
    public void refreshQuotationStorage() {
        quotationRepository.deleteAll();
    }

    //
    private List<Quotation> storeAndGetCoupleQuotations() {
        List<Quotation> res = new ArrayList<>();
        for (int i = 0; i < DOZEN; i++) {
            Quotation nextQuotation = getStubQuotation();
            Random random = new Random();
            Double latestPrice = nextQuotation.getLatestPrice() * random.nextDouble();
            Double changePercent = nextQuotation.getChangePercent() * random.nextDouble();
            Integer volume = nextQuotation.getVolume() * random.nextInt();
            nextQuotation.setLatestPrice(latestPrice);
            nextQuotation.setChangePercent(changePercent);
            nextQuotation.setVolume(volume);
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
        //res.setOpen("of course");
        res.setOpenTime(134375L);
        res.setLatestPrice(352.347);
        res.setChangePercent(-0.0004);
        res.setVolume(76543);
        return res;
    }
}
