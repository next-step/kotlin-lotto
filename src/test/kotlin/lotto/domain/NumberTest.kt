package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun can_not_has_minus() {
        assertThatThrownBy {
            Number("-1")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("0보다 작은값은 가질수 없습니다.")
    }

    @Test
    fun can_not_has_zero() {
        assertThatThrownBy {
            Number("0")
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("0보다 작은값은 가질수 없습니다.")
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
}
