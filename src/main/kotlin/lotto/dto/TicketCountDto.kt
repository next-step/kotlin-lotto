package lotto.dto

class TicketCountDto(ticketCountString: String) {
    val tickCount: Int

    init {
        validateTickCountString(ticketCountString)
        tickCount = ticketCountString.trim().toInt()
    }

    companion object {
        fun validateTickCountString(ticketCountString: String) {
            val errorMessage = "정수만을 입력해주세요.(입력값: $ticketCountString)"
            val parseNumber = ticketCountString.trim().toIntOrNull() ?: throw IllegalArgumentException(errorMessage)
            require(parseNumber >= 0) { errorMessage }
        }
    }
}
