package model

class WinningResult(private val lottoList: List<Lotto>, private val winningLotto: WinningLotto, private val money: Money) {
    fun stat(): List<LottoStat> {
        val lottoStatMap = mutableMapOf<Rank, Int>()
        lottoList.forEach {
            val rank = winningLotto.rank(it)
            lottoStatMap[rank] = (lottoStatMap[rank] ?: 0) + 1
        }
        return lottoStatMap.map { LottoStat(it.key, it.value) }.toList()
    }

    fun sum(): Int {
        return stat().sumBy { it.sumPrizeMoney() }
    }

    fun earningRate(): Double {
        return (sum() / money.value).toDouble()
    }
}
