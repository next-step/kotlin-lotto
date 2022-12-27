package lotto.domain

import jdk.jshell.Snippet.Status

class Statistics {

    private val value: MutableMap<Rank, MutableList<Lotto>> = mutableMapOf()

    private fun add(rank: Rank, lotto: Lotto) {
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

    companion object {
        fun drive(lottos: List<Lotto>, winLotto: WinLotto): Statistics {
            val statistic = Statistics()
            for(lotto in lottos) {
                val rank = winLotto.correspondLottoResult(lotto)
                statistic.add(rank, lotto)
            }
            return statistic
        }
    }

}