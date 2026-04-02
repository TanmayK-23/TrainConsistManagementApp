import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 72);

        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("AC", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("AC", 0)
        );
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgmt.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgmt.PassengerBogie("Test", -1)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b =
                new UseCase14TrainConsistMgmt.PassengerBogie("Sleeper", 50);

        assertEquals("Sleeper", b.type);
        assertEquals(50, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        UseCase14TrainConsistMgmt.PassengerBogie b1 =
                new UseCase14TrainConsistMgmt.PassengerBogie("A", 10);

        UseCase14TrainConsistMgmt.PassengerBogie b2 =
                new UseCase14TrainConsistMgmt.PassengerBogie("B", 20);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}