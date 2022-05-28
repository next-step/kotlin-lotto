package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBuilderTest {
    @Test
    fun `로또는 1에서 45까지의 숫자로 이루어져 있다`() {
        val lotto = LottoBuilder().create()
        assertThat(lotto.numbers.all { it in 1..45 }).isEqualTo(true)
    }

    @Test
    fun `로또는 6개의 숫자로 이루어져 있다`() {
        val lotto = LottoBuilder().create()
        assertThat(lotto.numbers.size).isEqualTo(6)
    }
}
