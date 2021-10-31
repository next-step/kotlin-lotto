package lotto.model

/**
 * 로또 숫자 하나의 객체
 * */
@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { EXCEPTION_NUMBER_FORMAT }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        const val EXCEPTION_NUMBER_FORMAT = "숫자 포멧에 맞지 않습니다."

        fun getLottoNumberRange(): List<Int> = (MIN_NUMBER..MAX_NUMBER).toList()
    }
}
