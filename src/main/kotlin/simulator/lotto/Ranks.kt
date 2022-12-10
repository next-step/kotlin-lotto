package simulator.lotto

data class Ranks(val values: List<Rank>) {
    fun rankCount(rank: Rank): Int {
        return values.count { it == rank }
    }

    fun totalMoney(): Int {
        return values.sumOf { it.winningMoney }
    }

    fun yield(money: Int): Double {
        return totalMoney() / money.toDouble()
    }

    companion object {
        fun match(lottoNumbersList: List<Numbers>, winningNumber: WinningNumber): Ranks {
            val rankList = lottoNumbersList
                .map { Rank.match(it, winningNumber) }

            return Ranks(rankList)
        }
    }
}
