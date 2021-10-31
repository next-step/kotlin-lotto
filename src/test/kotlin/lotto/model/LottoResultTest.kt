package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {

    @DisplayName("같은 번호가 5개 일치하면 2등이 된다.")
    @Test
    fun lottoResultWinners() {
        val lotto = LottoCreator.manualZeroPrice(1, 2, 3, 4, 5, 6)
        val winLottoNumbers = LottoNumbers.manual(1, 2, 3, 4, 5, 10)
        val result = LottoResult.of(listOf(lotto), winLottoNumbers)

        val expected = 1
        val actual = result.winners(LottoRank.Second)

        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("14,000원으로 5등이 1개 당첨된 경우 수익률은 0.35가 된다.")
    @Test
    fun lottoRateOfReturn() {
        val lotto = LottoCreator.manual(price = 1000, 10, 11, 12, 13, 14, 15)
        val fifthLotto = LottoCreator.manual(price = 1000, 10, 2, 12, 13, 14, 6)
        val winLottoNumbers = LottoNumbers.manual(1, 2, 3, 4, 5, 10)
        val lottoList = List(13) { lotto } + fifthLotto
        val result = LottoResult.of(lottoList, winLottoNumbers)

        val expected = 0.35f
        val actual = result.rateOfReturn

        assertThat(actual).isEqualTo(expected)
    }
}
