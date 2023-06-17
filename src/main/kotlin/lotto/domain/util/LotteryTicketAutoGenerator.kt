package lotto.domain.util

import lotto.domain.LotteryTicket
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

object LotteryTicketAutoGenerator {

    private val LOTTO_NUMBER_RANGE = IntRange(LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_END_NUMBER)

    fun generateAuto(): LotteryTicket {
        val lottoNumbers = LOTTO_NUMBER_RANGE.shuffled()
            .take(LottoNumbers.LOTTO_NUMBER_SIZE)
            .map { LottoNumber(it) }
        return LotteryTicket(lottoNumbers = LottoNumbers(lottoNumbers))
    }
}
