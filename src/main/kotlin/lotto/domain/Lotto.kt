package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBERS) { "Lotto must have 6 nubmers" }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_NUMBERS = 6
    }
}
