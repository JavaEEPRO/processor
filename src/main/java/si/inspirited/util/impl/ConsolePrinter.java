package si.inspirited.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import si.inspirited.service.IQuotationService;
import si.inspirited.util.IConsolePrinter;

@Component
public class ConsolePrinter implements IConsolePrinter, Runnable {

    @Autowired
    IQuotationService quotationService;

    @Override
    public void startPrintingConclusions() {
        run();
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(quotationService.getTop5QuotationsOrderedByLatestPrice4LastOfThemByCompanyName());
            System.out.println(quotationService.getTop5QuotationsOrderedByChangePercent());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
