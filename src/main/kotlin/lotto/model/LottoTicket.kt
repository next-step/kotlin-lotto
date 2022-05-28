package lotto.model

import lotto.constants.ErrorMessages
import lotto.domain.LottoTicketFactory
import lotto.domain.LottoTicketFactory.LOTTO_SIZE

/**
 * 로또 번호를 저장하는 모델 클래스
 * Created by Jaesungchi on 2022.05.24..
 */
data class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.none { it !in LottoTicketFactory.LOTTO_NUMBER_RANGE }) { ErrorMessages.NUMBER_IS_OVER_OR_UNDER_BASE }
        require(numbers.size == LOTTO_SIZE) { ErrorMessages.CANNOT_DUPLICATE_NUMBER }
    }

    companion object {
        fun of(numberList: List<Int>): LottoTicket {
            return LottoTicket(numberList.toSet())
        }
    }
}
