package lotto.domain

import lotto.domain.numbers.CustomNumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `당첨 번호는 사용자가 입력한 숫자로 이루어져있다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val winningLotto = WinningLotto(winningNumbers)

        assertThat(winningLotto.winningNumbers).isEqualTo(winningNumbers)
    }

    @Test
    fun `각 로또마다 당첨번호와 몇 개 겹치는지 계산할 수 있다`() {
        val winningNumbers = listOf(10, 20, 30, 35, 40, 45)
        val winningLotto = WinningLotto(winningNumbers)

        val threeMatchingNumbers = listOf(10, 20, 30, 1, 2, 3)
        val candidateLotto1 = Lotto(numbersGenerator = CustomNumbersGenerator(threeMatchingNumbers))

        val sixMatchingNumbers = listOf(40, 35, 10, 45, 20, 30)
        val candidateLotto2 = Lotto(numbersGenerator = CustomNumbersGenerator(sixMatchingNumbers))

        assertThat(winningLotto.getNumberOfMatchingNumbers(candidateLotto1)).isEqualTo(3)
        assertThat(winningLotto.getNumberOfMatchingNumbers(candidateLotto2)).isEqualTo(6)
    }
}
