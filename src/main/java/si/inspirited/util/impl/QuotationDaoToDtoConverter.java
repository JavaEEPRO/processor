package si.inspirited.util.impl;

import org.springframework.stereotype.Component;
import si.inspirited.dto.QuotationDto;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.util.IQuotationDaoToDtoConverter;

@Component
public class QuotationDaoToDtoConverter implements IQuotationDaoToDtoConverter {

    @Override
    public QuotationDto getDto(Quotation dao) {
        QuotationDto res = new QuotationDto();
        if (dao == null) { return res; }
        res.setId(dao.getId());
        res.setSymbol(dao.getSymbol());
        res.setCompanyName(dao.getCompanyName());
        res.setPrimaryExchange(dao.getPrimaryExchange());
        res.setCalculationPrice(dao.getCalculationPrice());
        res.setOpen(dao.getOpen());
        res.setOpenTime(dao.getOpenTime());
        res.setClose(dao.getClose());
        res.setCloseTime(dao.getCloseTime());
        res.setHigh(dao.getHigh());
        res.setLow(dao.getLow());
        res.setLatestPrice(dao.getLatestPrice());
        res.setLatestSource(dao.getLatestSource());
        res.setLatestTime(dao.getLatestTime());
        res.setLatestUpdate(dao.getLatestUpdate());
        res.setLatestVolume(dao.getLatestVolume());
        res.setIexRealTimePrice(dao.getIexRealTimePrice());
        res.setIexRealTimeSize(dao.getIexRealTimeSize());
        res.setIexLastUpdated(dao.getIexLastUpdated());
        res.setDelayedPrice(dao.getDelayedPrice());
        res.setDelayedPriceTime(dao.getDelayedPriceTime());
        res.setExtendedPrice(dao.getExtendedPrice());
        res.setExtendedChange(dao.getExtendedChange());
        res.setExtendedChangePercent(dao.getExtendedChangePercent());
        res.setExtendedPriceTime(dao.getExtendedPriceTime());
        res.setPreviousClose(dao.getPreviousClose());
        res.setPreviousVolume(dao.getPreviousVolume());
        res.setChange(dao.getChange());
        res.setChangePercent(dao.getChangePercent());
        res.setVolume(dao.getVolume());
        res.setIexMarketPercent(dao.getIexMarketPercent());
        res.setIexVolume(dao.getIexVolume());
        res.setAvgTotalVolume(dao.getAvgTotalVolume());
        res.setIexBidPrice(dao.getIexBidPrice());
        res.setIexAskPrice(dao.getIexAskPrice());
        res.setIexAskSize(dao.getIexAskSize());
        res.setMarketCap(dao.getMarketCap());
        res.setPeRatio(dao.getPeRatio());
        res.setWeek52High(dao.getWeek52High());
        res.setWeek52Low(dao.getWeek52Low());
        res.setYtdChange(dao.getYtdChange());
        res.setLastTradeTime(dao.getLastTradeTime());
        res.setUsMarketOpen(dao.isUsMarketOpen());
        return res;
    }
}
