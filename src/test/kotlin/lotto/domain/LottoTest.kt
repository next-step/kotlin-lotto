@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        val actual = Lotto.PRICE

        assertThat(actual).isEqualTo(1000)
    }

    @Test
    fun `로또 1장이 가지고 있는 번호는 6개이다`() {
        val lotto = Lotto()

        val actual = lotto.numbers

        assertThat(actual).hasSize(6)
    }
}
