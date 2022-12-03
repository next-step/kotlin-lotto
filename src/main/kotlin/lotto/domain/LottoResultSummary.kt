package lotto.domain

class LottoResultSummary(
    matchResults: List<MatchResult>,
) {
    val winners = MatchResult.winner().map { winnerMatchResults ->
        LottoResult(winnerMatchResults, countWinner(matchResults, winnerMatchResults))
    }
    val rateOfReturn: Double = matchResults.map { it.amount }.average() / TICKET_AMOUNT

    private fun countWinner(matchResults: List<MatchResult>, matchResult: MatchResult) =
        matchResults.count { matchResult.matchCount == it.matchCount && it.checkBonusBall(matchResult.isBonusBallMatched) }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
