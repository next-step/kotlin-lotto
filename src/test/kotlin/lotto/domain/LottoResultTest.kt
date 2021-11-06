package lotto.domain

import lotto.LottoNumberList.Companion.lottoNumberListOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 용지와 지난 당첨 번호를 이용해 당첨 결과를 산정 할 수 있다`() {
        val lastWeekNumber = LastWeekNumber(lottoNumberListOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, lastWeekNumber)
        val lottoGameList = mutableListOf<LottoGame>()
        val expectedWinningForEach = 1
        lottoGameList.apply {
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 6)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 7)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 8)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 7, 8)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 7, 8, 9)))
            add(LottoGame(lottoNumberListOf(1, 2, 7, 8, 9, 10)))
            add(LottoGame(lottoNumberListOf(1, 7, 8, 9, 10, 11)))
            add(LottoGame(lottoNumberListOf(7, 8, 9, 10, 11, 12)))
        }
        val resultMap = LottoResult(lottoGameList, lastWeekNumber, bonusNumber).getLottoResultMap()
        resultMap.forEach { assertThat(it.value).isEqualTo(expectedWinningForEach) }
    }

    @Test
    fun `로또 용지로 부터 당첨금을 받을 수 있는 게임만 확인 할 수 있다`() {
        val lastWeekNumber = LastWeekNumber(lottoNumberListOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = BonusNumber(7, lastWeekNumber)
        val lottoGameList = mutableListOf<LottoGame>()
        lottoGameList.apply {
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 6)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 7)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 5, 8)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 4, 7, 8)))
            add(LottoGame(lottoNumberListOf(1, 2, 3, 7, 8, 9)))
            add(LottoGame(lottoNumberListOf(1, 2, 7, 8, 9, 10)))
            add(LottoGame(lottoNumberListOf(1, 7, 8, 9, 10, 11)))
            add(LottoGame(lottoNumberListOf(7, 8, 9, 10, 11, 12)))
        }
        val resultMapOnlyWinning =
            LottoResult(lottoGameList, lastWeekNumber, bonusNumber).getLottoResultMapOnlyWinning()
        resultMapOnlyWinning.forEach {
            assertThat(it.key.result.numberOfHit >= LotteryWinningTypes.MINIMUM_WINNING_HITS).isTrue()
        }
    }
}
