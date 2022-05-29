package lotto

import lotto.LottoRule.LOTTO_NUMBER_COUNT

class LottoTickets(val lottery: List<LottoTicket> = emptyList())
open class LottoTicket(val numbers: List<LottoNumber>) {
    init {

        numbers.forEach {
            require(it.number > 0) { NOT_POSITIVE_NUMBER_MESSAGE }
        }

        require(numbers.size == LOTTO_NUMBER_COUNT) {
            NOT_MATCH_NUMBER_COUNT
        }
    }

    companion object {
        private const val NOT_POSITIVE_NUMBER_MESSAGE = "로또 번호는 0 또는 음수일 수 없습니다."
        private const val NOT_MATCH_NUMBER_COUNT = "로또 번호는 $LOTTO_NUMBER_COUNT 개의 숫자로 구성되어야 합니다"
    }
}

fun LottoTicket.hasBonusNumber(bonusLottoNumber: LottoNumber): Boolean = bonusLottoNumber in this.numbers
