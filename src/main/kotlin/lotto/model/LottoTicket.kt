package lotto.model

import lotto.domain.LottoTicketFactory

/**
 * 로또 번호를 저장하는 모델 클래스
 * Created by Jaesungchi on 2022.05.24..
 */
data class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.none { it !in LottoTicketFactory.LOTTO_NUMBER_RANGE })
        require(numbers.size == numbers.toSet().size)
    }
}
