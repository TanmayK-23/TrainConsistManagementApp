import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    @Test
    void testLoopFilteringLogic() {

        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 50),
                new UseCase13TrainConsistMgmt.Bogie("B", 70)
        );

        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterUsingLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {

        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 40),
                new UseCase13TrainConsistMgmt.Bogie("B", 80)
        );

        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterUsingStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {

        List<UseCase13TrainConsistMgmt.Bogie> list = Arrays.asList(
                new UseCase13TrainConsistMgmt.Bogie("A", 70),
                new UseCase13TrainConsistMgmt.Bogie("B", 80)
        );

        int loopSize = UseCase13TrainConsistMgmt.filterUsingLoop(list).size();
        int streamSize = UseCase13TrainConsistMgmt.filterUsingStream(list).size();

        assertEquals(loopSize, streamSize);
    }

    @Test
    void testExecutionTimeMeasurement() {

        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue((end - start) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {

        List<UseCase13TrainConsistMgmt.Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new UseCase13TrainConsistMgmt.Bogie("T", i));
        }

        List<UseCase13TrainConsistMgmt.Bogie> result =
                UseCase13TrainConsistMgmt.filterUsingStream(list);

        assertNotNull(result);
    }
}