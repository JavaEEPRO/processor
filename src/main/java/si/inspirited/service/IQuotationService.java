package si.inspirited.service;

import org.springframework.data.domain.Page;
import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface IQuotationService {

    Quotation addQuotation(Quotation quotation);

    Page<Quotation> getTop5QuotationsOrderedByLatestPrice();

    Page<Quotation> getLast5QuotationsOrderedDescByChangePercent();

    void refreshQuotationStorage();
}
