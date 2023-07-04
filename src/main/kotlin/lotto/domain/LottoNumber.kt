package lotto.domain

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { INVALID_NUMBER_ERROR_MESSAGE(number) }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        private val INVALID_NUMBER_ERROR_MESSAGE =
            { number: Int -> "로또 번호는 1~45 사이의 숫자만 가능합니다. ${number}는 불가합니다." }
    }
}
