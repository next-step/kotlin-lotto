package domain.lotto.error

class InvalidMoneyRangeException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_MONEY_RANGE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_MONEY_RANGE_EXCEPTION_MESSAGE = "%s는 Money 의 범위를 벗어난 값입니다."
    }
}
