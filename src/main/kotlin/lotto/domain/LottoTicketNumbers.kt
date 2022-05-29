package lotto.domain

class LottoTicketNumbers private constructor(val value: List<LottoTicketNumber>) {
    init {
        require(value.size == VALIDATED_LOTTO_TICKET_NUMBER_SIZE) { ERROR_MESSAGE_BY_LOTTO_NUMBER_SIZE }
        validateDuplicateLottoNumber()
    }

    fun notHasLottoNumber(lottoTicketNumber: LottoTicketNumber): Boolean {
        return !hasLottoNumber(lottoTicketNumber)
    }

    fun hasLottoNumber(lottoTicketNumber: LottoTicketNumber): Boolean {
        return value.contains(lottoTicketNumber)
    }

    fun findMatchedCount(compareLottoNumbers: LottoTicketNumbers): Int {
        return value.count { lottoTicketNumber -> compareLottoNumbers.value.contains(lottoTicketNumber) }
    }

    private fun validateDuplicateLottoNumber() {
        val sortedLottoTicketNumbers = value.sortedBy { lottoTicketNumber -> lottoTicketNumber.value }
        sortedLottoTicketNumbers.forEachIndexed { index, lottoTicketNumber ->
            if (index + 1 == sortedLottoTicketNumbers.size) return@forEachIndexed
            require(sortedLottoTicketNumbers[index + 1] != lottoTicketNumber) { "중복된 로또 번호가 있습니다" }
        }
    }

    companion object {
        private const val VALIDATED_LOTTO_TICKET_NUMBER_SIZE = 6
        private const val ERROR_MESSAGE_BY_LOTTO_NUMBER_SIZE =
            "로또 티켓은 $VALIDATED_LOTTO_TICKET_NUMBER_SIZE 개수의 로또 번호를 가지고 있어야 됩니다"

        fun ofString(lottoNumbersString: String, delimiters: String): LottoTicketNumbers {
            val lottoNumbersByInt = lottoNumbersString
                .split(delimiters)
                .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("숫자 데이터를 입력해주세요(입력값: $it)") }
            return ofInts(lottoNumbersByInt)
        }

        fun ofInts(lottoNumbersByInt: List<Int>): LottoTicketNumbers {
            return LottoTicketNumbers(lottoNumbersByInt.map { LottoTicketNumber(it) })
        }
    }
}
