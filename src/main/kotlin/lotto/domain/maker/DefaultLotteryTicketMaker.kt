package lotto.domain.maker

import lotto.data.LottoNumber
import lotto.data.LottoNumbers
import lotto.domain.LotteryTicket

class DefaultLotteryTicketMaker : LotteryTicketMaker {

    override fun createAutoLotteryTicket(): LotteryTicket {
        val numbers = (LottoNumber.LOTTERY_MIN_NUMBER..LottoNumber.LOTTERY_MAX_NUMBER).shuffled()
            .take(LotteryTicketMaker.LOTTERY_NUMBER_SIZE)
            .sorted()
        val lottoNumbers = LottoNumbers(numbers)
        return LotteryTicket(lottoNumbers)
    }
}
