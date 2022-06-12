package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `WinningNumbers는 당첨 번호와 보너스볼 번호를 보관한다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)

        val bonusBall = LottoNumber[7]
        val winningNumbers = WinningNumbers(lotto, bonusBall)

        assertThat(winningNumbers.numbers).isEqualTo(lotto)
        assertThat(winningNumbers.bonusBall).isEqualTo(bonusBall)
    }

    @Test
    fun `WinningNumbers의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(Lotto.from(1, 2, 3, 4, 5), LottoNumber[7])
        }
    }

    @Test
    fun `당첨 번호와 보너스볼 번호가 중복될 시 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
            val bonusBall = lotto.numbers.first()

            WinningNumbers(lotto, bonusBall)
        }
    }

    @Test
    fun `checkWith를 통해 Lottos를 받아 LottoResult를 반환한다`() {
        val lottos = Lottos.from(
            listOf(
                Lotto.from(8, 21, 23, 41, 42, 43),
                Lotto.from(8, 21, 23, 41, 42, 44),
                Lotto.from(8, 21, 23, 41, 43, 44),
                Lotto.from(8, 21, 23, 41, 1, 2),
                Lotto.from(8, 21, 23, 1, 2, 3)
            )
        )

        val winningNumbers = WinningNumbers(Lotto.from(8, 21, 23, 41, 42, 43), LottoNumber[4])

        val lottoResult = winningNumbers.checkWith(lottos)

        assertAll(
            { assertThat(lottoResult[LottoRank.FIFTH].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.FOURTH].count).isEqualTo(1) },
            { assertThat(lottoResult[LottoRank.THIRD].count).isEqualTo(2) },
            { assertThat(lottoResult[LottoRank.FIRST].count).isEqualTo(1) }
        )
    }
}
