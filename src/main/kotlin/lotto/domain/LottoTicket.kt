package lotto.domain

class LottoTicket private constructor(val lottoTicketNumbers: List<LottoTicketNumber>) {

    init {
        require(lottoTicketNumbers.size == VALIDATED_LOTTO_TICKET_NUMBER_SIZE) { ERROR_MESSAGE_BY_LOTTO_NUMBER_SIZE }
        validateDuplicateLottoNumber()
    }

    fun getMatchedCount(lottoNumbers: List<LottoTicketNumber>): Int {
        return lottoTicketNumbers.count { lottoTicketNumber -> lottoNumbers.contains(lottoTicketNumber) }
    }

    private fun validateDuplicateLottoNumber() {
        val sortedLottoTicketNumbers = lottoTicketNumbers.sortedBy { lottoTicketNumber -> lottoTicketNumber.value }
        sortedLottoTicketNumbers.forEachIndexed { index, lottoTicketNumber ->
            if (index + 1 == sortedLottoTicketNumbers.size) return@forEachIndexed
            require(sortedLottoTicketNumbers[index + 1] != lottoTicketNumber) { "중복된 로또 번호가 있습니다" }
        }
    }

    companion object {
        private const val VALIDATED_LOTTO_TICKET_NUMBER_SIZE = 6
        private const val ERROR_MESSAGE_BY_LOTTO_NUMBER_SIZE =
            "로또 티켓은 $VALIDATED_LOTTO_TICKET_NUMBER_SIZE 개수의 로또 번호를 가지고 있어야 됩니다"

        fun ofInts(lottNumbers: List<Int>): LottoTicket {
            return LottoTicket(lottNumbers.map { LottoTicketNumber(it) })
        }
    }
}
