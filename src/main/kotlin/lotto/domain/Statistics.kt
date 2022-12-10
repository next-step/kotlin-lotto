package lotto.domain

class Statistics {

    private val value: Map<Rank, MutableList<Lotto>> = mutableMapOf(
        Rank.MISS to mutableListOf(),
        Rank.FIFTH to mutableListOf(),
        Rank.FOURTH to mutableListOf(),
        Rank.THIRD to mutableListOf(),
        Rank.SECOND to mutableListOf(),
        Rank.FIRST to mutableListOf(),
    )

    fun add(rank: Rank, lotto: Lotto) {
        value[rank]?.add(lotto) ?: mutableListOf(lotto)
    }

    fun from(rank: Rank): List<Lotto> {
        if(rank == Rank.MISS) {
            return emptyList()
        }

        return value[rank]?.toList() ?: throw IllegalStateException()
    }

//    fun keys(): List<Int> = listOf(3, 4, 5, 6)
//    fun keys(): List<Rank> = listOf()
}