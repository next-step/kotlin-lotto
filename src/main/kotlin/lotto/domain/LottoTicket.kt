package lotto.domain

class LottoTicket(
    val lottoNumbers: LottoNumbers,
) {

    fun countMatchingLottoNumbers(lottoNumbers: LottoNumbers) =
        this.lottoNumbers.countMatchingLottoNumbers(lottoNumbers)

    fun contains(lottoNumber: LottoNumber) =
        this.lottoNumbers.contains(lottoNumber)

    companion object {
        const val LOTTO_TICKET_PRICE = 1_000L

        fun of(numbers: Set<Int>): LottoTicket {
            val lottoNumbers = LottoNumbers.of(numbers)
            return LottoTicket(lottoNumbers)
        }
    }
}
