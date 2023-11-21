package lotto.domain

class LottoTicket(private val lottoNumbers: LottoNumbers) {
    val readOnlyNumbers: List<LottoNumber> = lottoNumbers.readOnlyNumbers

    companion object {
        fun from(numbers: List<Int>): LottoTicket {
            require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) {
                "번호는 정확히 ${LottoConstants.NUMBERS_PER_TICKET}개 이어야 합니다."
            }
            require(numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }) {
                "번호는 ${LottoConstants.NUMBER_RANGE_START}에서 ${LottoConstants.NUMBER_RANGE_END} 범위 내에 있어야 합니다."
            }
            return LottoTicket(LottoNumbers(numbers.map { LottoNumber(it) }))
        }

        fun generate(): LottoTicket {
            val numbers = (LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END)
                .shuffled()
                .take(LottoConstants.NUMBERS_PER_TICKET)
                .map { LottoNumber(it) }
                .sortedBy { it.number }
            return LottoTicket(LottoNumbers(numbers))
        }
    }
}
