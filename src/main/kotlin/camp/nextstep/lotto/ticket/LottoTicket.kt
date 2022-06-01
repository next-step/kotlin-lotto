package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers

class LottoTicket(numbers: List<LottoNumber>) {

    val numbers = numbers.sortedBy { it.value }

    init {
        require(numbers.toSet().size == LottoNumbers.LOTTO_NUMBERS) { "로또 티켓은 서로 다른 ${LottoNumbers.LOTTO_NUMBERS}개의 숫자를 가질 수 있습니다. numbers=$numbers" }
    }

    companion object {
        fun of(vararg numbers: Int): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.of(it) }.toList())
        }
    }
}
