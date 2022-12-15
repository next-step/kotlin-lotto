package lotto

import lotto.common.LottoTicketPolicy.END_NUMBER
import lotto.common.LottoTicketPolicy.MAX_LOTTO_NUMBER_SIZE
import lotto.common.LottoTicketPolicy.START_NUMBER
import lotto.utils.RandomNumberGenerator

object LottoNumberSelector {
    fun select(): Set<Int> {
        val lottoNumbers = mutableSetOf<Int>()
        while (lottoNumbers.size < MAX_LOTTO_NUMBER_SIZE) {
            lottoNumbers.add(generateRandomNumber())
        }

        return lottoNumbers
    }

    private fun generateRandomNumber() = RandomNumberGenerator.generate(START_NUMBER..END_NUMBER)
}
