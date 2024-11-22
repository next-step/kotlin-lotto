package lotto

class LotteryTicketMachine(private val balance: Int) {
    init {
        require(balance >= TICKET_PRICE) {
            "로또 티켓을 구매하기 위해서는 최소 $TICKET_PRICE 원이 필요합니다"
        }
    }

    companion object {
        const val TICKET_PRICE: Int = 1000
    }
}
