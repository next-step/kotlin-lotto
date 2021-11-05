package domain.lotto.error

class InvalidTicketCountRangeException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_TICKET_COUNT_RANGE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_TICKET_COUNT_RANGE_EXCEPTION_MESSAGE = "%s는 Ticket 의 범위를 벗어난 값입니다."
    }
}
