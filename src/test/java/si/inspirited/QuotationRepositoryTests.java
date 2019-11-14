package si.inspirited;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    Quotation getStubQuotation() {
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
