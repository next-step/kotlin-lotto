package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import kotlin.RuntimeException

class StringAddCalculatorTest {
    @Test
    fun split_comma() {
        val calculator = StringAddCalculator("1,2")

        val result = calculator.plus()

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun split_colon() {
        val calculator = StringAddCalculator("1:2")

        val result = calculator.plus()

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun split_mix() {
        val calculator = StringAddCalculator("1:2,3")

        val result = calculator.plus()

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun input_null_or_blank() {
        val calculator = StringAddCalculator("")
        val calculator2 = StringAddCalculator(null)

        val result = calculator.plus()
        val result2 = calculator2.plus()

        assertThat(result).isEqualTo(0)
        assertThat(result2).isEqualTo(0)
    }

    @Test
    fun input_not_number() {
        assertThatThrownBy {
            StringAddCalculator("a")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("숫자가 아닌 값은 계산할수없습니다.")
    }

    @Test
    fun input_minus() {
        assertThatThrownBy {
            StringAddCalculator("-2:4")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("음수가 입력되었습니다.")
    }

    @Test
    fun one_number() {
        val calculator = StringAddCalculator("3")

        val result = calculator.plus()

        assertThat(result).isEqualTo(3)
    }

    @Test
    fun study_indexOf() {
        val string = "//;\n1;2;3"

        val position = string.indexOf("//")
        val position2 = string.indexOf("\n")

        assertThat(position).isEqualTo(0)
        assertThat(position2).isEqualTo(3)
    }

    @Test
    fun find_custom() {
        val string = "//;\n 1;2;3"
        val position = string.indexOf("//")
        val position2 = string.indexOf("\n")

        val custom = string.substring(position + 2, position2)

        assertThat(custom).isEqualTo(";")
    }
}
