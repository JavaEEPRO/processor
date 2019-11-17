package si.inspirited.service.impl;

import org.springframework.stereotype.Component;
import si.inspirited.dto.RowDto;
import si.inspirited.service.IEnabledStatusFilter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class EnabledStatusFilter implements IEnabledStatusFilter {

    @Override
    public List<RowDto> getEnabled(List<? extends Object> toFilter) {
        List<RowDto> res = new ArrayList<>();
        if (toFilter == null || toFilter.isEmpty()) {
            return res;
        }
        for (Object o : toFilter) {
            HashMap<String, Object> mapped = (HashMap<String, Object>) o;
            String symbol = "";
            Boolean enabled = false;
            String exchange = "";
            String name = "";
            String date = null;
            if (mapped.containsKey("symbol")) {
                symbol = (String) mapped.get("symbol");
            }
            if (mapped.containsKey("isEnabled")) {
                enabled = (Boolean) mapped.get("isEnabled");
            }
            if (mapped.containsKey("exchange")) {
                exchange = (String) mapped.get("exchange");
            }
            if (mapped.containsKey("name")) {
                name = (String) mapped.get("name");
            }
            if (mapped.containsKey("date")) {
                date = (String) mapped.get("date");
            }
                if (enabled) {
                    RowDto row = new RowDto();
                    row.setSymbol(symbol);
                    row.setEnabled(enabled);
                    row.setExchange(exchange);
                    row.setName(name);
                    row.setDate(date);

                    res.add(row);
                }
            }
            return res;
        }
    }
