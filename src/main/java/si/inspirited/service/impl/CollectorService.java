package si.inspirited.service.impl;

import org.springframework.stereotype.Service;
import si.inspirited.service.ICollectorService;

import java.util.List;

@Service
public class CollectorService implements ICollectorService {

    @Override
    public List<Object> getSnapshot() {
        return null;
    }
}
