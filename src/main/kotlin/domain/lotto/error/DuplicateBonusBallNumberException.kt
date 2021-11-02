package domain.lotto.error

class DuplicateBonusBallNumberException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "보너스 번호 %s 는 중복되었습니다."
    }
}