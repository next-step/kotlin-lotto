package lotto.domain

import lotto.domain.model.Lotto
import lotto.domain.model.LottoRank
import lotto.domain.model.LottoResult
import lotto.domain.model.WinningNumbers

object LottoWinningChecker {
    fun check(lottos: List<Lotto>, winningNumbers: WinningNumbers): LottoResult {
        return LottoResult.from(lottos.toLottoWinningMap(winningNumbers))
    }

    private fun List<Lotto>.toLottoWinningMap(winningNumbers: WinningNumbers): Map<Int, Int> {
        return map { lotto ->
            getNumberOfMatches(lotto, winningNumbers)
        }.groupingBy { numberOfMatches ->
            numberOfMatches
        }.eachCount().filter { (numberOfMatches, _) ->
            numberOfMatches in LottoRank.NUMBER_OF_MATCHES_RANGE
        }
    }

    private fun getNumberOfMatches(lotto: Lotto, winningNumbers: WinningNumbers): Int {
        return lotto.numbers.count { number ->
            winningNumbers.value.contains(number)
        }
    }
}
