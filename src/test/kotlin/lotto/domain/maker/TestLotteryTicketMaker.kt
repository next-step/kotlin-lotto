package lotto.domain.maker

import lotto.data.LottoNumbers
import lotto.domain.LotteryTicket

class TestLotteryTicketMaker : LotteryTicketMaker {
    override fun createAutoLotteryTicket(): LotteryTicket {
        val lottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        return LotteryTicket(lottoNumbers)
    }
}
