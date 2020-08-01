package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun number_has_minus() {
        assertThatThrownBy{
            Number("-1")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("음수값은 계산 할수없습니다.")
    }

    @Test
    fun number_not_has_minus() {
        val number = Number("1")
        val testNumber = Number("1")

        assertThat(number).isEqualTo(testNumber)
    }

    @Test
    fun is_not_number() {
        assertThatThrownBy {
            Number("a")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("숫자 이외의 값이 있습니다.")
    }
}
