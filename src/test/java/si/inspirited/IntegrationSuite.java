package si.inspirited;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import si.inspirited.integration.CustomPropertiesIntegrationTest;
import si.inspirited.integration.QuotationServiceIntegrationTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CollectorServiceTests.class,
        AdvancedCollectorServiceTests.class,
        QuotationRepositoryTests.class,
        QuotationServiceIntegrationTests.class,
        CustomPropertiesIntegrationTest.class,
})
public class IntegrationSuite {
}