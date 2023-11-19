package lotto.domain

class LottoTicket(numbers: List<Int>) {
    private val lottoNumbers = LottoNumbers(numbers)
    val readOnlyNumbers: List<Int> = lottoNumbers.readOnlyNumbers

    companion object {
        fun generate(): LottoTicket {
            val numbers = (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END)
                .shuffled()
                .take(LottoConstants.NUMBERS_PER_TICKET)
                .sorted()
            return LottoTicket(numbers)
        }
    }
}
