package lotto.entity

class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBER) { "로또는 6자리 숫자로 이루어져야 합니다." }
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBER = 6
        const val LOTTO_PRICE = 1000L
    }
}
