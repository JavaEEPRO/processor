package si.inspirited.service;

import org.springframework.data.domain.Page;
import si.inspirited.dto.QuotationDto;
import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface IQuotationService {

    QuotationDto addQuotation(Quotation quotation);

    Page<QuotationDto> getTop5QuotationsOrderedByLatestPrice4LastOfThemByCompanyName();

    Page<QuotationDto> getLast5QuotationsOrderedDescByChangePercent();

    void refreshQuotationStorage();
}
