package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun can_not_has_minus() {
        assertThatThrownBy {
            Number("-1")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("1~45의 값만 가질수 있습니다")
    }

    @Test
    fun can_not_has_zero() {
        assertThatThrownBy {
            Number("0")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("1~45의 값만 가질수 있습니다")
    }

    @Test
    fun can_not_has_blank() {
        assertThatThrownBy {
            Number("")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("공백값과 null값은 가질수 없습니다.")
    }

    @Test
    fun can_not_has_null() {
        assertThatThrownBy {
            Number(null)
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("공백값과 null값은 가질수 없습니다.")
    }

    @Test
    fun can_not_has_string() {
        assertThatThrownBy {
            Number("test")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("숫자 이외의 값은 가질수 없습니다.")
    }

    @Test
    fun can_has_1_to_45() {
        assertThatThrownBy {
            Number("46")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("1~45의 값만 가질수 있습니다")
    }

    @Test
    fun has_1_to_45() {
        for (number in 1..45) {
            Number(number.toString())
        }
    }

    @Test
    fun trim_test() {
        val number = Number("1")
        val number2 = Number(" 1 ")

        assertThat(number).isEqualTo(number2)
    }
}
