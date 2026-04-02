import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    @Test
    void testReduce_TotalSeatCalculation() {

        List<UseCase10TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56)
        );

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(128, result);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {

        List<UseCase10TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 56),
                new UseCase10TrainConsistMgmt.Bogie("First Class", 24)
        );

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(152, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {

        List<UseCase10TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72)
        );

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {

        List<UseCase10TrainConsistMgmt.Bogie> list = new ArrayList<>();

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {

        List<UseCase10TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Test", 50)
        );

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(50, result);
    }

    @Test
    void testReduce_AllBogiesIncluded() {

        List<UseCase10TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("A", 10),
                new UseCase10TrainConsistMgmt.Bogie("B", 20),
                new UseCase10TrainConsistMgmt.Bogie("C", 30)
        );

        int result = UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(60, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {

        List<UseCase10TrainConsistMgmt.Bogie> list = new ArrayList<>();
        list.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 72));

        int originalSize = list.size();

        UseCase10TrainConsistMgmt.totalCapacity(list);

        assertEquals(originalSize, list.size());
    }
}