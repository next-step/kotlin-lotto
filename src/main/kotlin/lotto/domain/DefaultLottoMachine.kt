package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_MAX_NUMBER
import lotto.domain.LottoNumber.Companion.LOTTO_MIN_NUMBER
import lotto.domain.LottoTicket.Companion.LOTTO_NUMBERS_SIZE

object DefaultLottoMachine : LottoMachine {

    private val LOTTO_NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).map(::LottoNumber)

    override fun generate(): LottoTicket {
        val lottoNumbers = LOTTO_NUMBERS.shuffled()
            .take(LOTTO_NUMBERS_SIZE)
        return LottoTicket(lottoNumbers)
    }
}
