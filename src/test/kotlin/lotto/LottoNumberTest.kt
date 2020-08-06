package lotto

import lotto.LottoNumber.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    internal fun create() {
        assertThat(of("1")).isEqualTo(of(1))
        assertThat(of("1") == of(1)).isTrue()
    }

    @Test
    internal fun invalid() {
        assertThatThrownBy { of(0) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { of(46) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
