package lotto

import lotto.domain.LastWeekNumber
import lotto.domain.LottoGame
import lotto.domain.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 용지와 지난 당첨 번호를 이용해 당첨 결과를 산정 할 수 있다`() {
        val lastWeekNumber = LastWeekNumber(listOf(1, 2, 3, 4, 5, 6))
        val lottoGameList = mutableListOf<LottoGame>()
        val expectedWinningForEach = 1
        lottoGameList.apply {
            add(LottoGame(listOf(1, 2, 3, 4, 5, 6)))
            add(LottoGame(listOf(1, 2, 3, 4, 5, 7)))
            add(LottoGame(listOf(1, 2, 3, 4, 7, 8)))
            add(LottoGame(listOf(1, 2, 3, 7, 8, 9)))
        }
        val resultMap = LottoResult(lottoGameList, lastWeekNumber).getLottoResultMap()
        resultMap.forEach { assertThat(it.value).isEqualTo(expectedWinningForEach) }
    }
}
