package si.inspirited.service.impl;

import org.springframework.stereotype.Service;
import si.inspirited.service.IAdvancedCollectorService;

import java.util.List;

@Service
public class AdvancedCollectorService implements IAdvancedCollectorService {

    @Override
    public List<Object> getExtendedCompanySnapshot(String url, String stockCode) {
        return null;
    }
}
