import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 56),
                new UseCase8TrainConsistMgmt.Bogie("General", 90)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Test", 70)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 70);

        assertEquals(0, result.size()); // equal excluded
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("AC", 50)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmt.Bogie("General", 90)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("AC", 40)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 80),
                new UseCase8TrainConsistMgmt.Bogie("General", 90)
        );

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 50);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmt.Bogie> list = new ArrayList<>();

        List<UseCase8TrainConsistMgmt.Bogie> result =
                UseCase8TrainConsistMgmt.filterBogies(list, 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));

        UseCase8TrainConsistMgmt.filterBogies(list, 60);

        assertEquals(1, list.size()); // original unchanged
    }
}