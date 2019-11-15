package si.inspirited.service.impl;

import org.springframework.stereotype.Component;
import si.inspirited.dto.SnapshotDto;
import si.inspirited.service.IEnabledStatusFilter;

import java.util.List;

@Component
public class EnabledStatusFilter implements IEnabledStatusFilter {

    @Override
    public List<SnapshotDto> getEnabled(List<? extends Object> toFilter) {
        return null;
    }
}
