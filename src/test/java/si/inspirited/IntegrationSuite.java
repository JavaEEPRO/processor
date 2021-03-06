package si.inspirited;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import si.inspirited.integration.CustomPropertiesIntegrationTest;
import si.inspirited.integration.QuotationServiceIntegrationTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomPropertiesIntegrationTest.class,
        CollectorServiceTests.class,
        AdvancedCollectorServiceTests.class,
        EnabledStatusFilterTests.class,
        QuotationRepositoryTests.class,
        QuotationServiceIntegrationTests.class
})
public class IntegrationSuite {
}