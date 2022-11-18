package lotto.domain

class WinningStatistics(private val winningNumbers: WinningNumbers) {
    private val matchCounter: Array<Int> = Array(7) { 0 }

    fun rank(lottos: Lottos) {
        lottos.lottoList.forEach {
            matchCounter[winningNumbers.rank(it)]++
        }
    }

    fun countOfMatchCount(matchCount: Int): Int {
        require(matchCount in matchCounter.indices)
        return matchCounter[matchCount]
    }

}
