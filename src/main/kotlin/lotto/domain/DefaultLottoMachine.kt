package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER

object DefaultLottoMachine : LottoMachine {

    private val LOTTO_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).map(::LottoNumber)

    override fun generateAuto(): LottoTicket {
        val lottoNumbers = LOTTO_NUMBERS.shuffled()
            .take(LottoTicket.LOTTO_NUMBERS_SIZE)
        return LottoTicket(lottoNumbers)
    }

    override fun generateManual(lottoNumbers: String): LottoTicket {
        return LottoTicket.of(lottoNumbers)
    }
}
