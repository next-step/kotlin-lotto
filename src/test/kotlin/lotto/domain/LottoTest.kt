@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

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
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
            LottoNumber(7),
        )

        val actual = catchThrowable {
            Lotto(lottoNumbers)
        }

        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers should be 6 numbers.")
    }

    @Test
    fun `지난주 당첨 번호가 주어지면 일치하는 숫자 수를 반환한다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )
        val winningNumbers = WinningNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        )

        val actual = lotto.getMatchedNumberCount(winningNumbers)

        assertThat(actual).isEqualTo(5)
    }
}
