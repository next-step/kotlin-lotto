package lotto.domain

import lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER
import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBERS_SIZE

class LottoTicket(
    val lottoNumbers: LottoNumbers,
) {

    fun countMatchingLottoNumbers(winningLottoNumbers: LottoNumbers) =
        lottoNumbers.countMatchingLottoNumbers(winningLottoNumbers)

    companion object {
        const val LOTTO_TICKET_PRICE = 1_000L

        fun of(vararg numbers: Int): LottoTicket {
            val lottoNumbers = LottoNumbers.of(*numbers)
            return LottoTicket(lottoNumbers)
        }

        fun issueByAuto(): LottoTicket {
            val lottoNumbers = generateRandomLottoNumbers()
            return LottoTicket(lottoNumbers)
        }

        private fun generateRandomLottoNumbers(): LottoNumbers {
            val candidateLottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
            val numbers = candidateLottoNumbers
                .shuffled()
                .take(LOTTO_NUMBERS_SIZE)
                .toSet()
            return LottoNumbers.of(numbers)
        }
    }
}
