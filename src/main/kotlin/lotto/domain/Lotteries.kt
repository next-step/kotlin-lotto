package lotto.domain

@JvmInline
value class Lotteries private constructor(val values: List<Lottery>) {

    fun rank(winning: Lottery): List<Ranking> {
        return values.map { Ranking.calculate(it.compareTo(winning)) }
    }

    companion object {
        fun of(values: List<Lottery>): Lotteries {
            return Lotteries(values)
        }
    }
}
