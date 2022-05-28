package lotto.domain

import lotto.domain.model.LottoRank
import lotto.domain.model.LottoResult
import lotto.domain.model.Lottos
import lotto.domain.model.WinningNumbers

object LottoWinningChecker {
    fun check(lottos: Lottos, winningNumbers: WinningNumbers): LottoResult {
        return LottoResult.from(lottos.toLottoWinningMap(winningNumbers))
    }

    private fun Lottos.toLottoWinningMap(winningNumbers: WinningNumbers): Map<Int, Int> {
        return value.map { lotto ->
            lotto.getNumberOfMatchesWith(winningNumbers)
        }.groupingBy { numberOfMatches ->
            numberOfMatches
        }.eachCount().filter { (numberOfMatches, _) ->
            numberOfMatches in LottoRank.NUMBER_OF_MATCHES_RANGE
        }
    }
}
