package lotto

import lotto.Fixtures.createSixLottoNumber
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.LottoRank
import lotto.model.LottoResult
import lotto.model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `같은 번호가 6개 일치하면 1등 로또가 당첨 된다`() {
        val lotto = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val winLottoNumbers = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(winLottoNumbers, bonusNumber)

        val result = LottoResult.of(listOf(lotto), winningLotto)

        assertThat(result.lottoRankList).contains(LottoRank.FIRST)
    }

    @Test
    fun `같은 번호가 5개 일치하고 보너스 볼이 일치한다면 2등 로또가 당첨 된다`() {
        val lotto = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))

        val winLottoNumbers = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 10)))
        val bonusNumber = LottoNumber.from(6)
        val winningLotto = WinningLotto(winLottoNumbers, bonusNumber)

        val result = LottoResult.of(listOf(lotto), winningLotto)

        assertThat(result.lottoRankList.contains(LottoRank.SECOND))
    }

    @Test
    fun `같은 번호가 5개 일치하고 보너스 볼이 일치하지 않는다면 3등 로또가 당첨 된다`() {
        val lotto = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))

        val winLottoNumbers = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 10)))
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(winLottoNumbers, bonusNumber)

        val result = LottoResult.of(listOf(lotto), winningLotto)

        assertThat(result.lottoRankList.contains(LottoRank.THIRD))
    }

    @Test
    fun `수익률을 정상적으로 구하는지 확인한다`() {
        val lotto = Lotto(createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val lotto2 = Lotto(createSixLottoNumber(listOf(40, 41, 42, 43, 44, 45)))
        val winLottoNumbers = Lotto(createSixLottoNumber(listOf(1, 2, 3, 43, 44, 45)))
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(winLottoNumbers, bonusNumber)

        val result = LottoResult.of(listOf(lotto, lotto2), winningLotto)

        val expectedProfitRate = "5.00"
        assertThat(result.profitRate).isEqualTo(expectedProfitRate)
    }
}
