package lotto.model

data class Lotto(
    val price: Int,
    val numbers: LottoNumbers
) {

    init {
        require(price >= 0)
    }

    fun match(numbers: LottoNumbers): Int = this.numbers.match(numbers)
}
