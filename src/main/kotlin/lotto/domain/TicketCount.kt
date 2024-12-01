package lotto.domain

class TicketCount(private val count: Int) {
    init {
        require(count >= 0) { "수동으로 구매할 티켓 수는 0 이상이어야 합니다." }
    }

    fun getValue(): Int = count
}
