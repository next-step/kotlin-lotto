package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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
            WinningNumbers.from(Lotto.from(1, 2, 3, 4, 5), LottoNumber[7])
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
    fun `checkWith를 통해 Lotto를 받아 당첨 순위를 확인할 수 있다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 7)
        val winningNumbers = WinningNumbers.from(Lotto.from(1, 2, 3, 4, 5, 6), LottoNumber[7])

        assertThat(winningNumbers.checkWith(lotto)).isEqualTo(LottoRank.SECOND)
    }
}
