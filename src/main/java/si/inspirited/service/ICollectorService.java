package si.inspirited.service;

import java.util.List;

public interface ICollectorService {

    List<Object> getSnapshot(final String url);
}
