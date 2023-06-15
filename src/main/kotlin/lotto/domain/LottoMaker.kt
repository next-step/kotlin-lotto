package lotto.domain

class LottoMaker {
    fun auto(): Lotto {
        val numbers = LOTTO_NUMBERS.shuffled().take(NUMBER_OF_LOTTO_NUMBERS)
        return Lotto(numbers)
    }

    companion object {
        val LOTTO_NUMBERS: List<Int> = (1..45).toList()
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6
    }
}
