package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

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
    fun split_custom() {
        val calculator = StringAddCalculator("//;\n1;2;3")

        val result = calculator.plus()

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun split_mix_custom() {
        val calculator = StringAddCalculator("//;\n1;2,3:4")

        val result = calculator.plus()

        assertThat(result).isEqualTo(10)
    }

    @Test
    fun one_number() {
        val calculator = StringAddCalculator("1")

        val result = calculator.plus()

        assertThat(result).isEqualTo(1)
    }

    @Test
    fun number_is_blank_or_null() {
        val calculator1 = StringAddCalculator("")
        val calculator2 = StringAddCalculator(null)

        val result1 = calculator1.plus()
        val result2 = calculator2.plus()

        assertThat(result1).isEqualTo(0)
        assertThat(result2).isEqualTo(0)
    }

    @Test
    fun not_number() {
        assertThatThrownBy {
            StringAddCalculator("a")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("숫자 이외의 값이 있습니다.")

    }

    @Test
    fun check_minus() {
        assertThatThrownBy {
            StringAddCalculator("-10")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("음수값은 계산 할수없습니다.")

    }
}
