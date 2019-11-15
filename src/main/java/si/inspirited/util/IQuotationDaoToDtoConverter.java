package si.inspirited.util;

import si.inspirited.dto.QuotationDto;
import si.inspirited.persistence.model.Quotation;

public interface IQuotationDaoToDtoConverter {

    QuotationDto getDto(Quotation dao);
}
