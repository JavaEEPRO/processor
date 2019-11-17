package si.inspirited.service;

import si.inspirited.persistence.model.Quotation;

public interface IAdvancedCollectorService {

    Quotation getExtendedCompanySnapshot(String url, String StockCode, final String token);
}
