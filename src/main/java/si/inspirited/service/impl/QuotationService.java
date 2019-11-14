package si.inspirited.service.impl;

import org.springframework.stereotype.Service;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IQuotationService;

import java.util.List;

@Service
public class QuotationService implements IQuotationService {

    @Override
    public Quotation addQuotation(Quotation quotation) {
        return null;
    }

    @Override
    public List<Quotation> getTop5QuotationsOrderedByLatestPrice() {
        return null;
    }

    @Override
    public List<Quotation> getLast5QuotationsOrderedDescByChangePercent() {
        return null;
    }
}
