package simulator.lotto

data class Ranks(private val values: List<Rank>) {
    fun rankCount(rank: Rank): Int {
        return values.count { it == rank }
    }

    fun totalMoney(): Int {
        return values.sumOf { it.prize() }
    }

    fun yield(money: Int): Double {
        return totalMoney() / money.toDouble()
    }

    companion object {
        fun aggregate(matches: List<Int>): Ranks {
            return Ranks(matches.mapNotNull { Rank.aggregate(it) })
        }
    }
}
