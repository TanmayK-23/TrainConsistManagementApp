import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        assertThrows(IllegalStateException.class, () ->
                UseCase20TrainConsistMgmt.searchWithValidation(arr, "BG101")
        );
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205"};

        assertDoesNotThrow(() ->
                UseCase20TrainConsistMgmt.searchWithValidation(arr, "BG101")
        );
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertTrue(UseCase20TrainConsistMgmt.searchWithValidation(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};

        assertFalse(UseCase20TrainConsistMgmt.searchWithValidation(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        assertTrue(UseCase20TrainConsistMgmt.searchWithValidation(arr, "BG101"));
    }
}