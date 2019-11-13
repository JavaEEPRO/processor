package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.inspirited.error.InvalidStockCodeException;
import si.inspirited.service.IAdvancedCollectorService;
import si.inspirited.service.ICollectorService;

import java.util.List;

@Service
public class AdvancedCollectorService implements IAdvancedCollectorService {

    @Autowired
    ICollectorService collectorService;

    @Override
    public Object getExtendedCompanySnapshot(String url, String stockCode) {
        if (stockCode == null || "".equals(stockCode.trim())) { throw new InvalidStockCodeException(); }
        String formattedUrl = url != null ? url.replace("{stockCode}", stockCode) : "";
        List<Object> data = collectorService.getSnapshot(formattedUrl);
        if (data.size() == 1) { return data.get(0); }
        return null;
    }
}
