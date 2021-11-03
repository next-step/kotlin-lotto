package lotto.domain

@JvmInline
value class Lottery private constructor(val numbers: LottoNumbers) {
    fun compareTo(lottery: Lottery): Int {
        return numbers.values.count { lottery.numbers.values.contains(it) }
    }

    companion object {
        fun of(numbers: LottoNumbers): Lottery {
            return Lottery(numbers)
        }
    }
}
