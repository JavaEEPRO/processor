package si.inspirited.service;

import si.inspirited.dto.SnapshotDto;

import java.util.List;

public interface ICollectorService {

    List<? extends Object> getSnapshot(final String url, final String token);
}
