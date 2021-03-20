package lotto.domain

class LottoesRank(
    private val value: Map<Rank, Int>
) {
    fun getRanks(): Map<Rank, Int> {
        return value
    }

    fun getWinningMoney(): Long {
        return value.map { rank ->
            rank.key.prizeMoney.toLong() * rank.value
        }.sum()
    }
}
