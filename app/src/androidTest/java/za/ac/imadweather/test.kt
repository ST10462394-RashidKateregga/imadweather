import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class test {

    @Test
    fun testMainActivityExitButton() {
        // Arrange
        val mainActivity = MainActivity()

        // Act
        mainActivity.exitButtonClick()

        // Assert
        assertTrue(mainActivity.isFinishing)
    }

    @Test
    fun testMainActivityNextButton() {
        // Arrange
        val mainActivity = MainActivity()

        // Act
        mainActivity.nextButtonClick()

        // Assert
        assertEquals(MainScreen::class.java.simpleName, ShadowActivity.getNextStartedActivity().component?.className)
    }

class MainScreenUnitTest {

    @Test
    fun testCalculateAverage_withValidData() {
        // Arrange
        val mainScreen = MainScreen()
        mainScreen.minTemps = intArrayOf(10, 12, 15, 18, 20, 22, 25)
        mainScreen.maxTemps = intArrayOf(20, 25, 28, 30, 32, 29, 27)

        // Act
        mainScreen.calculateAverage()

        // Assert
        assertEquals("Average Min: 17.43, Average Max: 27.00", mainScreen.averageTempView.text)
    }

    @Test
    fun testCalculateAverage_withInvalidData() {
        // Arrange
        val mainScreen = MainScreen()
        mainScreen.minTemps = intArrayOf(10, 12, 15, 18, 20, 22, 25)
        mainScreen.maxTemps = intArrayOf(20, 25, 28, 30, 32, 29, 27)
        // Set one of the inputs to an invalid value
        mainScreen.minTempInputs[3]?.text?.clear()
        mainScreen.minTempInputs[3]?.text?.append("invalid")

        // Act
        mainScreen.calculateAverage()

        // Assert
        assertEquals("Average Temperature: ", mainScreen.averageTempView.text)
    }
}
