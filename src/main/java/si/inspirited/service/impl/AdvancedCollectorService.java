package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.inspirited.error.InvalidStockCodeException;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IAdvancedCollectorService;
import si.inspirited.service.ICollectorService;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

@Service
public class AdvancedCollectorService implements IAdvancedCollectorService {

    @Autowired
    ICollectorService collectorService;

    @Override
    public Quotation getExtendedCompanySnapshot(final String url, final String stockCode, final String token) {
        if (stockCode == null || "".equals(stockCode.trim())) { throw new InvalidStockCodeException(); }
        String formattedUrl = url != null ? url : "";
        formattedUrl =  formattedUrl.replace("{stockCode}", stockCode);
        List<?> data = collectorService.getSnapshot(formattedUrl, token);
        if (data.size() == 1) {
            return getQuotationFromObject(data.get(0));
        }
        return null;
    }

    private Quotation getQuotationFromObject(Object object) {
        Quotation res = new Quotation();
        HashMap<String, Object> mapped = (HashMap<String, Object>) object;
        String symbol = "";
        String companyName = "";
        String primaryExchange = "";
        String calculationPrice = "";
        Integer open = null;
        Long openTime = null;
        Double close = null;
        Long closeTime = null;
        Double high = null;
        Double low = null;
        Double latestPrice = null;
        String latestSource = "";
        String latestTime = null;
        Long latestUpdate = null;
        Integer latestVolume = null;
        String iexRealTimePrice = "";
        Integer iexRealTimeSize = null;
        Long iexLastUpdated = null;
        Double delayedPrice = null;
        Long delayedPriceTime = null;
        Double extendedPrice = null;
        Integer extendedChange = null;
        Integer extendedChangePercent = null;
        Long extendedPriceTime = null;
        Double previousClose = null;
        Integer previousVolume = null;
        Double change = null;
        Double changePercent = null;
        Integer volume = null;
        String iexMarketPercent = "";
        Long iexVolume = null;
        Integer avgTotalVolume = null;
        Integer iexBidPrice = null;
        Integer iexBidSize = null;
        Integer iexAskPrice = null;
        Integer iexAskSize = null;
        Long marketCap = null;
        Double peRatio = null;
        Double week52High = null;
        Double week52Low = null;
        Double ytdChange = null;
        Long lastTradeTime = null;
        boolean isUsMarketOpen = false;

        if (mapped.containsKey("symbol")) {
            symbol = (String) mapped.get("symbol");
        }
        if (mapped.containsKey("companyName")) {
            companyName = (String) mapped.get("companyName");
        }
        if (mapped.containsKey("primaryExchange")) {
            primaryExchange = (String) mapped.get("primaryExchange");
        }
        if (mapped.containsKey("calculationPrice")) {
            calculationPrice = (String) mapped.get("calculationPrice");
        }
        if (mapped.containsKey("open")) {
            open = (Integer) mapped.get("open");
        }
        if (mapped.containsKey("openTime")) {
            openTime = (Long) mapped.get("openTime");
        }
        if (mapped.containsKey("close")) {
            close = (Double) mapped.get("close");
        }
        if (mapped.containsKey("closeTime")) {
            closeTime = (Long) mapped.get("closeTime");
        }
        if (mapped.containsKey("high")) {
            high = (Double) mapped.get("high");
        }
        if (mapped.containsKey("low")) {
            low = (Double) mapped.get("low");
        }
        if (mapped.containsKey("latestPrice")) {
            latestPrice = (Double) mapped.get("latestPrice");
        }
        if (mapped.containsKey("latestSource")) {
            latestSource = (String) mapped.get("latestSource");
        }
        if (mapped.containsKey("latestTime")) {
            latestTime = (String) mapped.get("latestTime");
        }
        if (mapped.containsKey("latestUpdate")) {
            latestUpdate = (Long) mapped.get("latestUpdate");
        }
        if (mapped.containsKey("latestVolume")) {
            latestVolume = (Integer) mapped.get("latestVolume");
        }
        if (mapped.containsKey("iexRealTimePrice")) {
            iexRealTimePrice = (String) mapped.get("iexRealTimePrice");
        }
        if (mapped.containsKey("iexRealTimeSize")) {
            iexRealTimeSize = (Integer) mapped.get("iexRealTimeSize");
        }
        if (mapped.containsKey("iexLastUpdated")) {
            iexLastUpdated = (Long) mapped.get("iexLastUpdated");
        }
        if (mapped.containsKey("delayedPrice")) {
            delayedPrice = (Double) mapped.get("delayedPrice");
        }
        if (mapped.containsKey("delayedPriceTime")) {
            delayedPriceTime = (Long) mapped.get("delayedPriceTime");
        }
        if (mapped.containsKey("extendedPrice")) {
            extendedPrice = (Double) mapped.get("extendedPrice");
        }
        if (mapped.containsKey("extendedChange")) {
            extendedChange = (Integer) mapped.get("extendedChange");
        }
        if (mapped.containsKey("extendedChangePercent")) {
            extendedChangePercent = (Integer) mapped.get("extendedChangePercent");
        }
        if (mapped.containsKey("extendedPriceTime")) {
            extendedPriceTime = (Long) mapped.get("extendedPriceTime");
        }
        if (mapped.containsKey("previousClose")) {
            previousClose = (Double) mapped.get("previousClose");
        }
        if (mapped.containsKey("previousVolume")) {
            previousVolume = (Integer) mapped.get("previousVolume");
        }
        if (mapped.containsKey("change")) {
            change = (Double) mapped.get("change");
        }
        if (mapped.containsKey("changePercent")) {
            changePercent = (Double) mapped.get("changePercent");
        }
        if (mapped.containsKey("volume")) {
            volume = (Integer) mapped.get("volume");
        }
        if (mapped.containsKey("iexMarketPercent")) {
            iexMarketPercent = (String) mapped.get("iexMarketPercent");
        }
        if (mapped.containsKey("iexVolume")) {
            iexVolume = (Long) mapped.get("iexVolume");
        }
        if (mapped.containsKey("avgTotalVolume")) {
            avgTotalVolume = (Integer) mapped.get("avgTotalVolume");
        }
        if (mapped.containsKey("iexBidPrice")) {
            iexBidPrice = (Integer) mapped.get("iexBidPrice");
        }
        if (mapped.containsKey("iexBidSize")) {
            iexBidSize = (Integer) mapped.get("iexBidSize");
        }
        if (mapped.containsKey("iexAskPrice")) {
            iexAskPrice = (Integer) mapped.get("iexAskPrice");
        }
        if (mapped.containsKey("iexAskSize")) {
            iexAskSize = (Integer) mapped.get("iexAskSize");
        }
        if (mapped.containsKey("marketCap")) {
            marketCap = (Long) mapped.get("marketCap");
        }
        if (mapped.containsKey("peRatio")) {
            peRatio = (Double) mapped.get("peRatio");
        }
        if (mapped.containsKey("week52High")) {
            week52High = (Double) mapped.get("week52High");
        }
        if (mapped.containsKey("week52Low")) {
            week52Low = (Double) mapped.get("week52Low");
        }
        if (mapped.containsKey("ytdChange")) {
            ytdChange = (Double) mapped.get("ytdChange");
        }
        if (mapped.containsKey("lastTradeTime")) {
            lastTradeTime = (Long) mapped.get("lastTradeTime");
        }
        if (mapped.containsKey("isUsMarketOpen")) {
            isUsMarketOpen = (Boolean) mapped.get("isUsMarketOpen");
        }
        res.setSymbol(symbol);
        res.setCompanyName(companyName);
        res.setPrimaryExchange(primaryExchange);
        res.setCalculationPrice(calculationPrice);
        res.setOpen(open);
        res.setOpenTime(openTime);
        res.setClose(close);
        res.setCloseTime(closeTime);
        res.setHigh(high);
        res.setLow(low);
        res.setLatestPrice(latestPrice);
        res.setLatestSource(latestSource);
        res.setLatestTime(latestTime);
        res.setLatestUpdate(latestUpdate);
        res.setLatestVolume(latestVolume);
        res.setIexRealTimePrice(iexRealTimePrice);
        res.setIexRealTimeSize(iexRealTimeSize);
        res.setIexLastUpdated(iexLastUpdated);
        res.setDelayedPrice(delayedPrice);
        res.setDelayedPriceTime(delayedPriceTime);
        res.setExtendedPrice(extendedPrice);
        res.setExtendedChange(extendedChange);
        res.setExtendedChangePercent(extendedChangePercent);
        res.setExtendedPriceTime(extendedPriceTime);
        res.setPreviousClose(previousClose);
        res.setPreviousVolume(previousVolume);
        res.setChange(change);
        res.setChangePercent(changePercent);
        res.setVolume(volume);
        res.setIexMarketPercent(iexMarketPercent);
        res.setIexVolume(iexVolume);
        res.setAvgTotalVolume(avgTotalVolume);
        res.setIexBidPrice(iexBidPrice);
        res.setIexBidSize(iexBidSize);
        res.setIexAskPrice(iexAskPrice);
        res.setIexAskSize(iexAskSize);
        res.setMarketCap(marketCap);
        res.setPeRatio(peRatio);
        res.setWeek52High(week52High);
        res.setWeek52Low(week52Low);
        res.setYtdChange(ytdChange);
        res.setLastTradeTime(lastTradeTime);
        res.setUsMarketOpen(isUsMarketOpen);

        return res;
    }
}
