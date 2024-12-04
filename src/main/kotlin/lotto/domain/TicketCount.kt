package lotto.domain

class TicketCount(private val value: Int) {
    init {
        require(value >= 0) { "티켓 수는 0 이상이어야 합니다." }
    }

    fun getValue(): Int = value
}
