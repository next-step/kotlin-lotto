package lotto.entity

class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBER)
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBER = 6
        const val LOTTO_PRICE = 1000L
    }
}
