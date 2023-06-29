package lotto.domain

data class LottoNumber(
    val number: Int
) {
    init {
        require(number in 1..45) { INVALID_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val INVALID_NUMBER_ERROR_MESSAGE = "로또 번호는 1~45 사이의 숫자만 가능합니다."
    }
}
