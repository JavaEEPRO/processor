package si.inspirited.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class CompanyWideInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String calculationPrice;
    private String open;
    private LocalTime openTime;
    private String close;
    private LocalTime closeTime;
    private String high;
    private String low;
    private String latestPrice;
    private String latestSource;
    private LocalTime latestTime;
    private Long latestUpdate;
    private String latestVolume;
    private String iexRealTimePrice;
    private Integer iexRealTimeSize;
    private Long iexLastUpdated;
    private String delayedPrice;
    private LocalTime delayedPriceTime;
    private String extendedPrice;
    private String extendedChange;
    private Integer extendedChangePercent;
    private LocalTime extendedPriceTime;
    private String previousClose;
    private Long previousVolume;
    private String change;
    private String changePercent;
    private String volume;
    private String iexMarketPercent;
    private Long iexVolume;
    private Long avgTotalVolume;
    private Integer iexBidPrice;
    private Integer iexBidSize;
    private Integer iexAskPrice;
    private Integer iexAskSize;
    private Long marketCap;
    private String peRatio;
    private String week52High;
    private String week52Low;
    private String ytdChange;
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

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
    }

    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
    }

    public LocalTime getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(LocalTime latestTime) {
        this.latestTime = latestTime;
    }

    public Long getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(Long latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public String getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(String latestVolume) {
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

    public String getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(String delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public LocalTime getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(LocalTime delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
    }

    public String getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(String extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public String getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(String extendedChange) {
        this.extendedChange = extendedChange;
    }

    public Integer getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(Integer extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
    }

    public LocalTime getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(LocalTime extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public Long getPreviousVolume() {
        return previousVolume;
    }

    public void setPreviousVolume(Long previousVolume) {
        this.previousVolume = previousVolume;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
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

    public Long getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(Long avgTotalVolume) {
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

    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio;
    }

    public String getWeek52High() {
        return week52High;
    }

    public void setWeek52High(String week52High) {
        this.week52High = week52High;
    }

    public String getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(String week52Low) {
        this.week52Low = week52Low;
    }

    public String getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(String ytdChange) {
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
}
