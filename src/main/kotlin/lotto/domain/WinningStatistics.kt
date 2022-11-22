package lotto.domain

class WinningStatistics(private val winningNumbers: WinningNumbers) {
    private val ranks: MutableList<Rank> = mutableListOf()
    private val moneyUsed: Long
        get() = ranks.size * Lotto.PRICE.value
    val profit: Float
        get() {
            var prizeTotal = 0f
            Rank.values().forEach { rank ->
                prizeTotal += rank.prize * ranks.count { it == rank }
            }
            return prizeTotal / moneyUsed
        }

    fun rank(lottos: Lottos) {
        lottos.lottoList.forEach {
            ranks.add(winningNumbers.rank(it))
        }
    }

    fun countOfMatchCount(matchCount: Int): Int {
        return ranks.count { it == Rank.from(matchCount) }
    }

    fun prizeOfMatchCount(matchCount: Int): Int {
        return Rank.prizeOfMatchCount(matchCount)
    }
}
