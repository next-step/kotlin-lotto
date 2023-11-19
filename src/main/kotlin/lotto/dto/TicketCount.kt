package lotto.dto

data class TicketCount(val count: Int) {
    init {
        require(count > 0) { "티켓 수는 음수일 수 없습니다." }
    }
}
