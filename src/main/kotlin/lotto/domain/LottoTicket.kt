package lotto.domain

class LottoTicket(
    val lottoNumbers: LottoNumbers,
) {

    fun countMatchingLottoNumbers(winningLottoNumbers: LottoNumbers) =
        lottoNumbers.countMatchingLottoNumbers(winningLottoNumbers)

    companion object {
        const val LOTTO_TICKET_PRICE = 1_000L

        fun of(numbers: Set<Int>): LottoTicket {
            val lottoNumbers = LottoNumbers.of(numbers)
            return LottoTicket(lottoNumbers)
        }
    }
}
