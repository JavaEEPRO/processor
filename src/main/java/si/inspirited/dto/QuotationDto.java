package si.inspirited.dto;

import java.time.LocalTime;
import java.util.Objects;

public class QuotationDto {

    private Long id;

    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String calculationPrice;
    private Integer open;
    private Long openTime;
    private Double close;
    private Long closeTime;
    private Double high;
    private Double low;
    private Double latestPrice;
    private String latestSource;
    private String latestTime;
    private Long latestUpdate;
    private Integer latestVolume;
    private String iexRealTimePrice;
    private Integer iexRealTimeSize;
    private Long iexLastUpdated;
    private Double delayedPrice;
    private Long delayedPriceTime;
    private Double extendedPrice;
    private Integer extendedChange;
    private Integer extendedChangePercent;
    private Long extendedPriceTime;
    private Double previousClose;
    private Integer previousVolume;
    private Double change;
    private Double changePercent;
    private Integer volume;
    private String iexMarketPercent;
    private Long iexVolume;
    private Integer avgTotalVolume;
    private Integer iexBidPrice;
    private Integer iexBidSize;
    private Integer iexAskPrice;
    private Integer iexAskSize;
    private Long marketCap;
    private Double peRatio;
    private Double week52High;
    private Double week52Low;
    private Double ytdChange;
    private Long lastTradeTime;
    private boolean isUsMarketOpen;

    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
    }

    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public Long getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(Long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public Integer getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(Integer latestVolume) {
        this.latestVolume = latestVolume;
    }

    public String getIexRealTimePrice() {
        return iexRealTimePrice;
    }

    public void setIexRealTimePrice(String iexRealTimePrice) {
        this.iexRealTimePrice = iexRealTimePrice;
    }

    public Integer getIexRealTimeSize() {
        return iexRealTimeSize;
    }

    public void setIexRealTimeSize(Integer iexRealTimeSize) {
        this.iexRealTimeSize = iexRealTimeSize;
    }

    public Long getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(Long iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
    }

    public Double getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(Double delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public Long getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(Long delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public Double getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(Double extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public Integer getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(Integer extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Integer getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Integer extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public Long getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(Long extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public Integer getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(Integer previousVolume) {
        this.previousVolume = previousVolume;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double change) {
        this.change = change;
    }

    public Double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(Double changePercent) {
        this.changePercent = changePercent;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(String iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
    }

    public Long getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(Long iexVolume) {
        this.iexVolume = iexVolume;
    }

    public Integer getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(Integer avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
    }

    public Integer getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(Integer iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
    }

    public Integer getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(Integer iexBidSize) {
        this.iexBidSize = iexBidSize;
    }

    public Integer getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(Integer iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
    }

    public Integer getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(Integer iexAskSize) {
        this.iexAskSize = iexAskSize;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Double getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Double peRatio) {
        this.peRatio = peRatio;
    }

    public Double getWeek52High() {
        return week52High;
    }

    public void setWeek52High(Double week52High) {
        this.week52High = week52High;
    }

    public Double getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(Double week52Low) {
        this.week52Low = week52Low;
    }

    public Double getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(Double ytdChange) {
        this.ytdChange = ytdChange;
    }

    public Long getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(Long lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public boolean isUsMarketOpen() {
        return isUsMarketOpen;
    }

    public void setUsMarketOpen(boolean usMarketOpen) {
        isUsMarketOpen = usMarketOpen;
    }

    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotationDto that = (QuotationDto) o;
        return isUsMarketOpen == that.isUsMarketOpen &&
                Objects.equals(id, that.id) &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, companyName);
    }
}
