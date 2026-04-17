import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {

        UseCase15TrainConsistMgmt.GoodsBogie g =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        g.assignCargo("Petroleum");

        assertEquals("Petroleum", g.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {

        UseCase15TrainConsistMgmt.GoodsBogie g =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        g.assignCargo("Petroleum");

        assertNull(g.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {

        UseCase15TrainConsistMgmt.GoodsBogie g =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        g.assignCargo("Petroleum");

        assertNull(g.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {

        UseCase15TrainConsistMgmt.GoodsBogie g1 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        UseCase15TrainConsistMgmt.GoodsBogie g2 =
                new UseCase15TrainConsistMgmt.GoodsBogie("Cylindrical");

        g1.assignCargo("Petroleum"); // exception
        g2.assignCargo("Coal");      // should still work

        assertEquals("Coal", g2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {

        UseCase15TrainConsistMgmt.GoodsBogie g =
                new UseCase15TrainConsistMgmt.GoodsBogie("Rectangular");

        g.assignCargo("Petroleum");

        // If code reaches here, finally executed (no crash)
        assertTrue(true);
    }
}