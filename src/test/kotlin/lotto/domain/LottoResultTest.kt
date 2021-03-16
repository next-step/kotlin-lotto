package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `로또당첨 결과를 반환한다`() {
        val winningLotto = WinningLotto(lotto = Lotto((1..6).map { LottoNumber(it) }), bonusNumber = LottoNumber(7))
        val lotto = Lotto(lottoNumbers = (2..7).map { LottoNumber(it) })
        val lottoResult = LottoResult(winningLotto, listOf(lotto))

        assertThat(lottoResult.result()).contains(LottoPrize.SECOND_PRIZE)
    }
}
