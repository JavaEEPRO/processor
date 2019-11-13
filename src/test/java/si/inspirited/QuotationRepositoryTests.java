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

    private Quotation STUB_QUOTATION = new Quotation();

    @Test
    public void pushQuotationToRepo_ifCouldFindItStored_thenCorrect() {
        Quotation returnedQuotation = quotationRepository.save(getStubQuotation());
        assertNotNull(returnedQuotation);
        Long id = returnedQuotation.getId();
        assertNotNull(id);
        returnedQuotation.setId(null);
        assertEquals(STUB_QUOTATION, returnedQuotation);
        Quotation queriedFromRepoQuotation = quotationRepository.getOne(id);
        assertEquals(id, queriedFromRepoQuotation.getId());
    }

    Quotation getStubQuotation() {
        STUB_QUOTATION.setSymbol("MRCY");
        STUB_QUOTATION.setCompanyName("Microsauce");
        STUB_QUOTATION.setPrimaryExchange("PARAUS");
        STUB_QUOTATION.setCalculationPrice("rise");
        STUB_QUOTATION.setOpen("of course");
        STUB_QUOTATION.setOpenTime(LocalTime.of(11,12));
        STUB_QUOTATION.setLatestPrice(352.347);
        STUB_QUOTATION.setChangePercent(-0.0004);
        return STUB_QUOTATION;
    }
}
