package si.inspirited;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import si.inspirited.dto.RowDto;
import si.inspirited.service.IAdvancedCollectorService;
import si.inspirited.service.ICollectorService;
import si.inspirited.service.IEnabledStatusFilter;
import si.inspirited.service.IQuotationService;
import si.inspirited.util.IConsolePrinter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ProcessorApplication implements CommandLineRunner {

	@Autowired
	ICollectorService collectorService;

	@Autowired
	IAdvancedCollectorService advancedCollectorService;

	@Autowired
	IQuotationService quotationService;

	@Autowired
	IEnabledStatusFilter enabledStatusFilter;

	@Autowired
	IConsolePrinter consolePrinter;

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {



		while (true) {
			consolePrinter.startPrintingConclusions();
			List<RowDto> enabledCompanies = enabledStatusFilter.getEnabled(collectorService.getSnapshot(env.getProperty("url.source.allCompaniesReview"), env.getProperty("token")));
			for (RowDto company : enabledCompanies) {
				ExecutorService executorService = Executors.newFixedThreadPool(10);
				executorService.submit(() -> {
						quotationService.addQuotation(advancedCollectorService.getExtendedCompanySnapshot(env.getProperty("url.source.extendedCompanyReview"), company.getSymbol(), env.getProperty("token")));
				});
			}
		}
	}
}
