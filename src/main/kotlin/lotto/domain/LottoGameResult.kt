package lotto.domain

import lotto.entity.Lotto
import lotto.enums.prize.Prize

class LottoGameResult(val lotto: Lotto, val winningLottoNumber: WinningLottoNumber) {
    fun getResult(): Map<Prize, Int> {
        val matchResults = lotto.compareAllWithWinningNumbers(winningLottoNumber)

        val resultMap =
            mutableMapOf(
                Prize.THREE to 0,
                Prize.FOUR to 0,
                Prize.FIVE to 0,
                Prize.BONUS to 0,
                Prize.SIX to 0,
            )

        matchResults.forEach { result ->
            toPrize(result, resultMap)
        }

        return resultMap
    }

    private fun toPrize(
        result: LottoMatchResult,
        resultMap: MutableMap<Prize, Int>,
    ) {
        result.toPrize()?.let { prize ->
            resultMap[prize] = resultMap.getOrDefault(prize, 0) + 1
        }
    }
}
