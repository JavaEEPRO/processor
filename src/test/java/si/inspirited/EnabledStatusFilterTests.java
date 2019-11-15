package si.inspirited;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import si.inspirited.dto.RowDto;
import si.inspirited.service.IEnabledStatusFilter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EnabledStatusFilterTests {

    @Autowired
    IEnabledStatusFilter enabledStatusFilter;

    public String mockData = "[{'symbol':'A','isEnabled':true}, {'symbol':'B','isEnabled':false}, {'symbol':'C','isEnabled':false}, {'symbol':'D','isEnabled':false}, {'symbol':'E','isEnabled':true}, {'symbol':'F','isEnabled':false}, {'symbol':'G','isEnabled':false}, {'symbol':'H','isEnabled':false}, {'symbol':'I','isEnabled':false}, {'symbol':'J','isEnabled':false}, {'symbol':'K','isEnabled':false}, {'symbol':'L','isEnabled':true}]";

    @Test
    public void getEnabledIsCalledWithCoupleObjectsAreFeedInThere_whenReturnedListContainsOnlyEnabled_thenCorrect() {
        JSONArray dataAsJson = new JSONArray(mockData);
        List<Object> toFeed = dataAsJson.toList();

        List<RowDto> res = enabledStatusFilter.getEnabled(toFeed);
        assertNotNull(res);
        assertTrue(res.size() < toFeed.size());
        for (RowDto snapshot : res) {
            assertTrue(snapshot::isEnabled);
        }

    }



}
