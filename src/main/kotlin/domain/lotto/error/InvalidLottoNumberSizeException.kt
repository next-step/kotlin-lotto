package domain.lotto.error

class InvalidLottoNumberSizeException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE = "Lotto 에 속한 LottoNumber 의 개수 %s는 6이 아니다."
    }
}
