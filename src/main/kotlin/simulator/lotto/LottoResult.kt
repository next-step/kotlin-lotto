package simulator.lotto

class LottoResult(private val ranks: List<Rank>) {
    fun rankCount(rank: Rank): Int {
        return ranks.count{ it == rank }
    }

    fun totalMoney(): Int {
        return ranks.sumOf { it.prize() }
    }

    fun yield(money:Int):Double{
        return totalMoney() / money.toDouble()
    }

    companion object {
        fun aggregate(lottos: List<Lotto>, winningLotto: Lotto): LottoResult {
            val ranks = lottos.map { it.match(winningLotto) }
                .mapNotNull { Rank.match(it) }

            return LottoResult(ranks)
        }
    }
}
