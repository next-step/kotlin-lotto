package lotto.domain

class Statistics {

    private val value: MutableMap<Rank, MutableList<Lotto>> = mutableMapOf()

    fun add(rank: Rank, lotto: Lotto) {
        value[rank]?.add(lotto) ?: init(rank).add(lotto)
    }

    fun from(rank: Rank): List<Lotto> {
        return value[rank]?.toList() ?: init(rank).toList()
    }

    private fun init(rank: Rank): MutableList<Lotto> {
        val list = mutableListOf<Lotto>()
        value[rank] = list
        return list
    }

}