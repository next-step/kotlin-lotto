package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun checkWith(winningNumbers: WinningNumbers): LottoResult {
        return LottoResult.from(toLottoWinningMap(winningNumbers))
    }

    private fun toLottoWinningMap(winningNumbers: WinningNumbers): Map<Int, Int> {
        return value.map { lotto ->
            lotto.getNumberOfMatchesWith(winningNumbers)
        }.groupingBy { numberOfMatches ->
            numberOfMatches
        }.eachCount().filter { (numberOfMatches, _) ->
            numberOfMatches in LottoRank.NUMBER_OF_MATCHES_RANGE
        }
    }
}
