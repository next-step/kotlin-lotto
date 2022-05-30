package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호는 사용자가 입력한 숫자로 이루어져있다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val winningLotto = WinningLotto(winningNumbers, 7)

        assertThat(winningLotto.winningNumbers.list).isEqualTo(winningNumbers)
    }

    @Test
    fun `보너스 볼 번호를 저장해야 한다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val bonusBallNumber = 7
        val winningLotto = WinningLotto(winningNumbers, bonusBallNumber)

        assertThat(winningLotto.bonusNumber).isEqualTo(bonusBallNumber)
    }

    @Test
    fun `보너스 볼 번호와 당첨 번호가 겹치면 IllegalArgumentsException 이 발생한다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val bonusBallNumber = 10

        assertThatIllegalArgumentException().isThrownBy { WinningLotto(winningNumbers, bonusBallNumber) }
    }

    @Test
    fun `각 로또마다 당첨번호와 몇 개 겹치는지 계산할 수 있다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val winningLotto = WinningLotto(winningNumbers, 7)

        val threeMatchingNumbers = listOf(10, 20, 30, 1, 2, 3)
        val candidateLotto1 = Lotto(threeMatchingNumbers)

        assertThat(winningLotto.getNumberOfMatchingNumbers(candidateLotto1)).isEqualTo(3)
    }

    @Test
    fun `당첨 번호와 순서가 달라도 몇 개 겹치는지 계산할 수 있다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val winningLotto = WinningLotto(winningNumbers, 7)

        val sixMatchingNumbers = listOf(40, 35, 10, 45, 20, 30)
        val candidateLotto2 = Lotto(sixMatchingNumbers)

        assertThat(winningLotto.getNumberOfMatchingNumbers(candidateLotto2)).isEqualTo(6)
    }
}
