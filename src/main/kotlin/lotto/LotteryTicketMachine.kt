package lotto

class LotteryTicketMachine(balance: Int) {
    var balance = balance
        private set

    init {
        require(balance >= TICKET_PRICE) {
            "로또 티켓을 구매하기 위해서는 최소 $TICKET_PRICE 원이 필요합니다"
        }
    }

    fun issueTicket(numbers: List<Int> = (1..45).shuffled().take(6)): LottoTicket? {
        if (balance < TICKET_PRICE) {
            return null
        }
        balance -= TICKET_PRICE
        return LottoTicket(numbers)
    }

    companion object {
        const val TICKET_PRICE: Int = 1000
    }
}
