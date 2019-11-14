package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<Quotation> getTop5QuotationsOrderedByLatestPrice() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return quotationRepository.findTopOrderedByLatestPrice(pageRequest);
    }

    @Override
    public Page<Quotation> getLast5QuotationsOrderedDescByChangePercent() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return quotationRepository.findLastOrderedDescByChangePercent(pageRequest);
    }

    @Override
    public void refreshQuotationStorage() {
        quotationRepository.deleteAll();
    }
}
