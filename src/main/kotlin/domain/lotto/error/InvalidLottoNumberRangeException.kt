package domain.lotto.error

class InvalidLottoNumberRangeException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "%s는 LottoNumber 의 범위를 벗어난 값입니다."
    }
}