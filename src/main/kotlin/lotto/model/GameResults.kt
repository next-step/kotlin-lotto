package lotto.model

class GameResults(private val ranks: List<Rank>) {

    fun of(rank: Rank): Int {
        return ranks.filter { it.name == rank.name }.size
    }
}
