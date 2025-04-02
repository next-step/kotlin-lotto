import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
        val text = "1:2,3,4:5"
        val result = calculator.sum(text)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `when custom delimiter is entered`() {
        val text = "//;\n1;2;3;4;5"
        val result = calculator.sum(text)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `when custom delimiter and default delimiter is entered`() {
        val text = "//-\n1:2,3-4-5"
        val result = calculator.sum(text)
        assertThat(result).isEqualTo(15)
    }

    @Test
    fun `when unknown delimiter is entered`() {
        val text = "1.2:3:4:5"
        assertThrows<IllegalArgumentException> {
            calculator.sum(text)
        }
    }

    @Test
    fun `when non-numeric number is entered`() {
        val text = "t,2,3,4,5"
        assertThrows<IllegalArgumentException> {
            calculator.sum(text)
        }
    }

    @Test
    fun `when number is not positioned at the beginning or end`() {
        val text = ",2,3,4,5,"
        assertThrows<IllegalArgumentException> {
            calculator.sum(text)
        }
    }

    @Test
    fun `when consecutive delimiters are entered`() {
        val text = "1,,2,3,4,5"
        assertThrows<IllegalArgumentException> {
            calculator.sum(text)
        }
    }
}
