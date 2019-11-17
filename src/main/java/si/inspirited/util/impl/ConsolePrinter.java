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
    public Runnable startPrintingConclusions() {
        run();
        return this;
    }

    @Override
    public void run() {
        while(true) {
            quotationService.getTop5QuotationsOrderedByVolume4LastOfThemByCompanyName().getContent().forEach(System.out::println);
            System.out.println("");
            quotationService.getTop5QuotationsOrderedByChangePercent().getContent().forEach(System.out::println);
            System.out.println("===============================");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
