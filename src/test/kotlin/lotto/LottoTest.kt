package lotto

import lotto.Lotto.Companion.of
import lotto.Lotto.Companion.ofComma
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class LottoTest {
    @Test
    internal fun create() {
        val lotto = of(1, 2, 3, 4, 5, 6)
        assertThat(lotto).isEqualTo(ofComma("1, 2, 3, 4, 5, 6"))
    }

    @Test
    internal fun invalid() {
        assertThatThrownBy { of(1, 2, 3, 4, 5, 5) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    internal fun matchCount() {
        val lotto1 = of(1, 2, 3, 4, 5, 6)
        val lotto2 = of(1, 2, 3, 4, 5, 7)
        assertThat(lotto1.match(lotto2)).isEqualTo(5)
    }

    @Test
    internal fun contains() {
        val lotto = of(1, 2, 3, 4, 5, 6)
        assertThat(lotto.contains(1)).isTrue()
        assertThat(lotto.contains(7)).isFalse()
    }
}
