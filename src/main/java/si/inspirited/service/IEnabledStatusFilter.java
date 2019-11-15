package si.inspirited.service;

import si.inspirited.dto.SnapshotDto;

import java.util.List;

public interface IEnabledStatusFilter {

    List<SnapshotDto> getEnabled(List<? extends Object> toFilter);
}
