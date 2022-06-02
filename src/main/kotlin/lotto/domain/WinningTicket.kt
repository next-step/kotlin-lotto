package lotto.domain

class WinningTicket private constructor(
    private val lottoNumbers: LottoNumbers
) {
    fun matchResult(lottoTicket: LottoTicket): WinningAmount {
        return WinningAmount.findByMatchCount(
            matchCount = lottoNumbers.matchedNumberCount(other = lottoTicket.lottoNumbers)
        )
    }

    companion object {
        fun of(numbers: List<Int>): WinningTicket = WinningTicket(LottoNumbers(convertToLottoNumberSet(numbers)))

        private fun convertToLottoNumberSet(numbers: List<Int>) =
            numbers.map { LottoNumber.from(it) }
                .toSet()
    }
}
