package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IQuotationService;

import java.util.List;

@Service
public class QuotationService implements IQuotationService {

    @Autowired
    QuotationRepository quotationRepository;

    @Override
    public Quotation addQuotation(Quotation quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public List<Quotation> getTop5QuotationsOrderedByLatestPrice() {
        return quotationRepository.findTopOrderedByLatestPrice();
    }

    @Override
    public List<Quotation> getLast5QuotationsOrderedDescByChangePercent() {
        return null;
    }
}
