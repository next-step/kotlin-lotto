@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 1장의 가격은 1000원이다`() {
        val actual = Lotto.PRICE

        assertThat(actual).isEqualTo(1000)
    }

    @Test
    fun `로또 1장이 가지고 있는 번호는 6개이다`() {
        val actual = Lotto.NUMBER_COUNT

        assertThat(actual).isEqualTo(6)
    }

    @Test
    fun `로또 번호가 6개의 숫자가 아니면 IllegalArgumentException이 발생한다`() {
        val lottoNumbers = (1..7).map(::LottoNumber)

        val actual = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        assertThat(actual).hasMessageContaining("Lotto numbers should be 6 numbers.")
    }

    @Test
    fun `지난주 당첨 번호가 주어지면 일치하는 숫자 수를 반환한다`() {
        val lotto = Lotto(
            numbers = (1..6).map(::LottoNumber)
        )
        val winningNumbers = WinningNumbers(
            numbers = (2..7).map(::LottoNumber)
        )

        val actual = lotto.getMatchedNumberCount(winningNumbers)

        assertThat(actual).isEqualTo(5)
    }

    @Test
    fun `보너스 번호가 주어지면 보너스 번호와 일치하는 번호가 있는지 여부를 반환한다`() {
        val lotto = Lotto(
            numbers = (1..6).map(::LottoNumber)
        )
        val bonusNumber = LottoNumber(3)

        val actual = lotto.isBonusNumberMatch(bonusNumber)

        assertThat(actual).isEqualTo(true)
    }
}
