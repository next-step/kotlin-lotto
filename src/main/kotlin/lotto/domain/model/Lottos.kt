package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    fun checkWith(winningNumbers: WinningNumbers): LottoResult {
        return LottoResult.from(getLottoWinningMap(winningNumbers))
    }

    private fun getLottoWinningMap(winningNumbers: WinningNumbers): Map<NumberOfMatches, Int> {
        return value.map { lotto ->
            lotto.getNumberOfMatchesWith(winningNumbers)
        }.groupingBy { numberOfMatches ->
            numberOfMatches
        }.eachCount().filter { (numberOfMatches, _) ->
            numberOfMatches.isWin()
        }
    }
}
