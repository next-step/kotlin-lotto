package lotto.domain.maker

import lotto.data.LottoNumbers
import lotto.domain.LotteryTicket

interface LotteryTicketMaker {
    val lotteryTicketPrice
        get() = LOTTERY_TICKET_PRICE

    fun createAutoLotteryTicket(): LotteryTicket

    fun createManualLotteryTicket(lottoNumbers: LottoNumbers): LotteryTicket {
        return LotteryTicket(lottoNumbers)
    }

    companion object {
        const val LOTTERY_TICKET_PRICE = 1000
        const val LOTTERY_NUMBER_SIZE = 6
    }
}
