package lotto

import lotto.LottoRule.LOTTO_NUMBER_COUNT

class LottoTickets(val lottoTickets: List<LottoTicket> = emptyList())
open class LottoTicket(val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            NOT_MATCH_NUMBER_COUNT
        }
    }

    companion object {
        private const val NOT_MATCH_NUMBER_COUNT = "로또 번호는 $LOTTO_NUMBER_COUNT 개의 숫자로 구성되어야 합니다"
    }
}
