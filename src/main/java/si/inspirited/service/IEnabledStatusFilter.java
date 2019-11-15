package si.inspirited.service;

import si.inspirited.dto.RowDto;

import java.util.List;

public interface IEnabledStatusFilter {

    List<RowDto> getEnabled(List<? extends Object> toFilter);
}
