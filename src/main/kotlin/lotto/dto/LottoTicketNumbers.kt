package lotto.dto

import lotto.domain.LottoConstants

data class LottoTicketNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.NUMBERS_PER_TICKET) {
            "번호는 정확히 ${LottoConstants.NUMBERS_PER_TICKET}개 이어야 합니다."
        }
        require(numbers.all { it in LottoConstants.NUMBER_RANGE_START..LottoConstants.NUMBER_RANGE_END }) {
            "번호는 ${LottoConstants.NUMBER_RANGE_START}에서 ${LottoConstants.NUMBER_RANGE_END} 범위 내에 있어야 합니다."
        }
    }
}
