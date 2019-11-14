package si.inspirited.service;

import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface IQuotationService {

    Quotation addQuotation(Quotation quotation);

    List<Quotation> getTop5QuotationsOrderedByLatestPrice();

    List<Quotation> getLast5QuotationsOrderedDescByChangePercent();
}
