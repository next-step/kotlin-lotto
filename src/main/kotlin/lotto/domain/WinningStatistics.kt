package lotto.domain

class WinningStatistics(private val winningNumbers: WinningNumbers) {
    private val matchCounter: Array<Int> = Array(LottoNumbers.LOTTO_NUMBER_COUNT + 1) { 0 }
    private var moneyUsed: Long = 0
    val profit: Float
        get() {
            var prizeTotal = 0f
            Prize.values().forEach {
                prizeTotal += it.prize * matchCounter[it.matchCount]
            }
            return prizeTotal / moneyUsed
        }

    fun rank(lottos: Lottos) {
        lottos.lottoList.forEach {
            matchCounter[winningNumbers.rank(it)]++
            moneyUsed += Lotto.PRICE.value
        }
    }

    fun countOfMatchCount(matchCount: Int): Int {
        require(matchCount in matchCounter.indices)
        return matchCounter[matchCount]
    }

    fun prizeOfMatchCount(matchCount: Int): Int {
        return Prize.prizeOfMatchCount(matchCount)
    }
}
