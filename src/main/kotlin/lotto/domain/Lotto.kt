package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBERS) { "Lotto must have 6 numbers. Input: [${numbers.size}] numbers" }
    }

    fun matchedNumber(lotto: Lotto): Int {
        return this.numbers.intersect(lotto.numbers.toSet()).size
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_NUMBERS = 6
    }
}
