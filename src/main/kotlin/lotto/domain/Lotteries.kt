package lotto.domain

@JvmInline
value class Lotteries private constructor(val values: List<Lottery>) {

    operator fun plus(lotteries: Lotteries): Lotteries {
        return Lotteries(values + lotteries.values)
    }

    companion object {
        fun of(values: List<Lottery>): Lotteries {
            return Lotteries(values)
        }
    }
}
