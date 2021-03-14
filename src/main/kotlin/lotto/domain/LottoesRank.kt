package lotto.domain

class LottoesRank(
    private val value: Map<Rank, List<LottoTicket>>
) {
    fun getRanks(): Map<Rank, Int> {
        return value.mapValues { rank ->
            rank.value.size
        }
    }

    fun getWinningMoney(): Long {
        return value.map { rank ->
            rank.key.prizeMoney.toLong() * rank.value.size
        }.sum()
    }
}
