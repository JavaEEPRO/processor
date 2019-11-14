package si.inspirited.service;

import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface IQuotationService {

    Quotation addQuotation();

    List<Quotation> getTop5QuotationsOrderedByLatestPrice();

    List<Quotation> getLast5QuotationsOrderedDescByChangePercent();
}
