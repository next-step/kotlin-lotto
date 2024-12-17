package lotto.entity

import lotto.domain.LottoMatchResult
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import lotto.enums.prize.Prize

class Lotto(val manualLotto: MutableList<LottoNumber>, val autoLotto: MutableList<LottoNumber>) {
    fun getResultMap(
        prizeMap: MutableMap<Prize, Int>,
        winningLottoNumber: WinningLottoNumber,
    ): Map<Prize, Int> {
        val matchResults = compareAllWithWinningNumbers(winningLottoNumber)
        matchResults.forEach { result ->
            toPrize(result, prizeMap)
        }
        return prizeMap
    }

    private fun compareAllWithWinningNumbers(winningLottoNumber: WinningLottoNumber): List<LottoMatchResult> {
        return (manualLotto + autoLotto).map { lottoNumber ->
            lottoNumber.compareWithWinningNumbers(winningLottoNumber)
        }
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
