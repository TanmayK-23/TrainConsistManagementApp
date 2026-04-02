import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmtTest {

    @Test
    void testGrouping_BogiesGroupedByType() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56),
                new UseCase9TrainConsistMgmt.Bogie("AC Chair", 60)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(2, result.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {

        List<UseCase9TrainConsistMgmt.Bogie> list = new ArrayList<>();

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("First Class", 24)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(1, result.size());
        assertEquals(1, result.get("First Class").size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmt.Bogie("AC Chair", 56),
                new UseCase9TrainConsistMgmt.Bogie("First Class", 24)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {

        List<UseCase9TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase9TrainConsistMgmt.Bogie("Sleeper", 70)
        );

        Map<String, List<UseCase9TrainConsistMgmt.Bogie>> result =
                UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {

        List<UseCase9TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase9TrainConsistMgmt.Bogie("Sleeper", 72));

        int originalSize = list.size();

        UseCase9TrainConsistMgmt.groupBogies(list);

        assertEquals(originalSize, list.size());
    }
}