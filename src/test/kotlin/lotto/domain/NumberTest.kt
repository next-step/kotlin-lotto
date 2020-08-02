package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun can_not_has_minus() {
        assertThatThrownBy {
            Number("-1")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("0보다 작은값은 입력하면 안됩니다.")
    }

    @Test
    fun can_not_has_zero() {
        assertThatThrownBy {
            Number("0")
        }.isInstanceOf(RuntimeException::class.java).hasMessageContaining("0보다 작은값은 입력하면 안됩니다.")
    }
}