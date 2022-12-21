package lotto.domain

class Statistics {

    private val value: MutableMap<Rank, MutableList<Lotto>> = mutableMapOf()

    fun add(rank: Rank, lotto: Lotto) {
        val list = value[rank] ?: init(rank)
        list.add(lotto)
    }

    fun from(rank: Rank): List<Lotto> {
        val result = value[rank] ?: init(rank)
        return result.toList()
    }

    private fun init(rank: Rank): MutableList<Lotto> {
        val list = mutableListOf<Lotto>()
        value[rank] = list
        return list
    }

}