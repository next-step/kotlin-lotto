package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBERS) { "Lotto must have 6 numbers" }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun match(lotto: Lotto): Int {
        return this.numbers.filter {
            lotto.numbers.contains(it)
        }.size
    }

    companion object {
        const val LOTTO_NUMBERS = 6
    }
}
