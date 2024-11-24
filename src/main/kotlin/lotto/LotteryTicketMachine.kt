package lotto

class LotteryTicketMachine(balance: Int, totalCost: Int = 0) {
    var balance = balance
        private set
    var totalCost: Int = totalCost
        private set

    init {
        require(balance >= TICKET_PRICE) {
            "로또 티켓을 구매하기 위해서는 최소 $TICKET_PRICE 원이 필요합니다"
        }
    }

    fun issueTicket(numbers: List<LottoNumber> = LOTTERY_NUMBERS_POOL.shuffled().take(6).map(::LottoNumber)): LottoTicket? {
        if (balance < TICKET_PRICE) {
            return null
        }
        balance -= TICKET_PRICE
        totalCost += TICKET_PRICE
        return LottoTicket(numbers)
    }

    companion object {
        const val TICKET_PRICE: Int = 1000
        private val LOTTERY_NUMBERS_POOL: IntRange = (1..45)
    }
}
