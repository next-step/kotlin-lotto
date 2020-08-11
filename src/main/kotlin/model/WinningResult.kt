package model

object WinningResult {
    fun of(lottoList: List<Lotto>, winningLotto: WinningLotto): List<LottoStat> {
        val lottoStatMap = mutableMapOf<Rank, Int>()
        lottoList.forEach {
            val rank = winningLotto.rank(it)
            lottoStatMap[rank] = (lottoStatMap[rank] ?: 0) + 1
        }
        return lottoStatMap.map { LottoStat(it.key, it.value) }.toList()
    }

    fun sum(list: List<LottoStat>): Int {
        return list.sumBy { it.sumPrizeMoney() }
    }

    fun earningRate(list: List<LottoStat>, money: Money): Double {
        return (sum(list) / money.value).toDouble()
    }
}
