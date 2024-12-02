import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName(value = "쉼표, 콜론을 구분자로 분리한다.")
    @CsvSource(value = ["'1,2',3","'1:3',4"] )
    fun stringSplitTest(inputString : String, expacted : Int) {
        assertThat(StringCalculator(inputString)).isEqualTo(StringCalculator(expacted))
    }
}
