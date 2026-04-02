import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmt.validateTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode("pet-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId(""));
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11TrainConsistMgmt.validateTrainId("TRN-1234X"));
        assertFalse(UseCase11TrainConsistMgmt.validateCargoCode("PET-ABX"));
    }
}