package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 구입금액에 대한 수익률을 계산해준다`() {
        val testLotto = Lotto((1..6).map { LottoNumber(it) }.toSet())
        val winningNumbers = testLotto
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottos = listOf<Lotto>(testLotto)

        val resultMap = lottos.groupBy { winningLotto.calculatePrize(it) }
            .mapValues { it.value.size }

        val result = LottoResult(resultMap)
        Assertions.assertThat(result.getProfitRate(Money(1000))).isEqualTo(2000000.0)
    }
}
