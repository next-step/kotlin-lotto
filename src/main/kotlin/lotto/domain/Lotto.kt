package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {

    constructor(vararg numbers: Int) : this(numbers.map(LottoNumber::of).toList())

    init {
        require(numbers.size == LOTTO_NUMBERS) { "Lotto must have $LOTTO_NUMBERS numbers. Input: [${numbers.size}] numbers" }
        require(numbers.toSet().size == 6) { "Duplicate number exists. $numbers" }
    }

    fun countOfMatch(lotto: Lotto): Int {
        return this.numbers.intersect(lotto.numbers.toSet()).size
    }

    companion object {
        const val LOTTO_NUMBERS = 6

        fun random(): Lotto {
            return Lotto(LottoNumber.numbers.shuffled().take(Lotto.LOTTO_NUMBERS).sortedBy { it.value })
        }
    }
}
