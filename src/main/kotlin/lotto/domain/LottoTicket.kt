package lotto.domain

class LottoTicket private constructor(val lottoTicketNumbers: LottoTicketNumbers) {
    fun getMatchedCount(compareLottoNumbers: LottoTicketNumbers): Int {
        return lottoTicketNumbers.findMatchedCount(compareLottoNumbers)
    }

    companion object {
        fun ofString(lottoNumbersString: String, delimiter: Delimiter): LottoTicket {
            return ofInts(delimiter.parseNumbers(lottoNumbersString))
        }

        fun ofInts(lottoNumbers: List<Int>): LottoTicket {
            return LottoTicket(LottoTicketNumbers.ofInts(lottoNumbers))
        }
    }
}
