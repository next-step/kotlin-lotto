package lotto.domain

import lotto.common.LottoTicketPolicy.END_NUMBER
import lotto.common.LottoTicketPolicy.MAX_LOTTO_NUMBER_SIZE
import lotto.common.LottoTicketPolicy.START_NUMBER
import lotto.utils.RandomNumberGenerator

object LottoNumberSelector {
    fun select(): Set<LottoNumber> {
        val lottoNumbers = mutableSetOf<LottoNumber>()
        while (lottoNumbers.size < MAX_LOTTO_NUMBER_SIZE) {
            lottoNumbers.add(generateLottoNumber())
        }

        return lottoNumbers
    }

    private fun generateLottoNumber() = LottoNumber(RandomNumberGenerator.generate(START_NUMBER..END_NUMBER))
}
