import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StringAdditionCalculatorTest {

    private lateinit var calculator: StringAdditionCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAdditionCalculator()
    }

    @Test
    fun `when comma is delimiter`() {
        val text = "1,2,3,4,5"
        val result = calculator.sum(text)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `when colon is delimiter`() {
        val text = "1:2:3:4:5"
        val result = calculator.sum(text)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `when both comma and colon are delimiter`() {

    }

    @Test
    fun `when custom delimiter is entered`() {

    }

    @Test
    fun `when unknown delimiter is entered`() {

    }

    @Test
    fun `when non-numeric number is entered`() {

    }

    @Test
    fun `when number is not positioned at the beginning and end`() {

    }

    @Test
    fun `when consecutive delimiters are entered`() {

    }
}
