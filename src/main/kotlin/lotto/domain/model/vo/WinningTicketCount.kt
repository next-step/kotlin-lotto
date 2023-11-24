package lotto.domain.model.vo

/**
 * 당첨된 로또 티켓 개수
 * */
@JvmInline
value class WinningTicketCount(val ticketCount: Int) {
    init {
        require(ticketCount >= MIN_TICKET_COUNT) {
            "당첨된 로또 티켓의 장수는 ${MIN_TICKET_COUNT}보다 많은 숫자만 들어와야 합니다."
        }
    }

    companion object {
        private const val MIN_TICKET_COUNT = 0

        fun valueOf(ticketCount: Int) = WinningTicketCount(ticketCount)
    }
}
