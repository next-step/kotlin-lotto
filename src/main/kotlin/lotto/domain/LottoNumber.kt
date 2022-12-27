package lotto.domain

import lotto.common.LottoTicketPolicy.END_NUMBER
import lotto.common.LottoTicketPolicy.START_NUMBER

@JvmInline
value class LottoNumber(
    val number: Int,
) {
    init {
        require(number in START_NUMBER..END_NUMBER) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }
}
