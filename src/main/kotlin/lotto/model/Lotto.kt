package lotto.model

data class Lotto(
    val numbers: List<LottoNumbers>,
) {
    val size: Int
        get() = numbers.size

    companion object {
        const val PRICE = 1000
    }
}

data class LottoNumbers(
    val value: List<LottoNumber>,
) {
    init {
        require(value.size == NUMBER_OF_LOTTO_DIGIT) { "로또 번호는 ${NUMBER_OF_LOTTO_DIGIT}개의 숫자로 구성되어야 합니다." }
    }

    companion object {
        const val NUMBER_OF_LOTTO_DIGIT = 6
    }
}
