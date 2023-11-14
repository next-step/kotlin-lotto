package lotto.domain.model.vo

/**
 * 로또 티켓 개수
 * */
@JvmInline
value class TicketCount(val ticketCount: Int) {
    init {
        require(ticketCount in MIN_TICKET_COUNT..MAX_TICKET_COUNT) {
            "당첨된 로또 티켓의 장수는 $MIN_TICKET_COUNT ~ ${MAX_TICKET_COUNT}개의 숫자만 들어와야 합니다."
        }
    }

    companion object {
        private const val MIN_TICKET_COUNT = 0
        private const val MAX_TICKET_COUNT = 100

        fun valueOf(prize: Int) = TicketCount(prize)
    }
}
