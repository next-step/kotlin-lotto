package lotto.data

import lotto.domain.LotteryTicket
import lotto.domain.LotteryTickets

data class LotteryTicketNumbers(
    val lotteryTicketNumbers: List<LotteryTicketNumber>
) {
    companion object {
        fun from(lotteryTickets: LotteryTickets): LotteryTicketNumbers {
            val lotteryTicketNumbers = lotteryTickets.makeLotteryTicketNumberList()
            return LotteryTicketNumbers(lotteryTicketNumbers)
        }
    }
}

data class LotteryTicketNumber(
    val numbers: List<Int>
) {
    companion object {
        fun from(lotteryTicket: LotteryTicket): LotteryTicketNumber {
            return LotteryTicketNumber(lotteryTicket.numbers)
        }
    }
}
