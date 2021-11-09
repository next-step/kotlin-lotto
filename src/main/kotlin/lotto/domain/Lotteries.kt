package lotto.domain

@JvmInline
value class Lotteries private constructor(val values: List<Lottery>) {

    companion object {
        fun of(values: List<Lottery>): Lotteries {
            return Lotteries(values)
        }
    }
}
