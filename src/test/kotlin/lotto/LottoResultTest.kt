package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `로또 수익률 계산`() {
        val lotto1 = Lotto((1..6).map { LottoNumber(it) })
        val winningNumbers = lotto1
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottos = listOf<Lotto>(lotto1)
        val lottoResult = LottoResult.getResult(winningLotto, lottos)

        Assertions.assertThat(lottoResult.getProfitRate(1000)).isEqualTo("2000000.0")
    }
}
