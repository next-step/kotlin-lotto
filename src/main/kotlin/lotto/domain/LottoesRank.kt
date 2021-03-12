package lotto.domain

class LottoesRank(
    private val value: Map<Rank, List<LottoTicket>>
) {
    fun getRanks(): Map<Rank, Int> {
        return value.mapValues { rank ->
            rank.value.size
        }
    }

    fun getWinningMoney(): Int {
        return value.map { rank ->
            rank.key.prizeMoney * rank.value.size
        }.sum()
    }
}