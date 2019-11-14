package si.inspirited.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuotationServiceIntegrationTests {

    @Autowired
    QuotationRepository quotationRepository;

    @Test
    public void addQuotation_whenReceivedListContainsIt_thenCorrect() {
        Quotation quotationToSave = getStubQuotation();
        Quotation quotationReturned = quotationRepository.save(quotationToSave);
        Long id = quotationReturned.getId();
        assertNotNull(quotationReturned);
        assertNotEquals(id, null);
        quotationReturned.setId(null);
        assertEquals(quotationToSave, quotationReturned);
        List<Quotation> receivedList = quotationRepository.findTopOrderedByLatestPrice();
        assertEquals(1, receivedList.size());
        Quotation quotationQueried = receivedList.get(0);
        quotationQueried.setId(null);
        assertEquals(quotationToSave, quotationQueried);
    }

    //
    private Quotation getStubQuotation() {
        Quotation res = new Quotation();
        res.setSymbol("PRFCT");
        res.setCompanyName("Microsouth");
        res.setPrimaryExchange("PREX");
        res.setCalculationPrice("highest");
        res.setOpen("any time");
        res.setOpenTime(LocalTime.of(01,02));
        res.setLatestPrice(213.731);
        res.setChangePercent(-0.0007);
        return res;
    }
}
