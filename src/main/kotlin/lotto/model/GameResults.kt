package lotto.model

class GameResults(ranks: List<Rank>) {
    private val ranks: List<Rank> = ranks

    fun of(rank: Rank): Int {
        return ranks.filter { it.name == rank.name }.size
    }
}
