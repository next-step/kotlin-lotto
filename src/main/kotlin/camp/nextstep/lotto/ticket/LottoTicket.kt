package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumbers

class LottoTicket private constructor(numbers: LottoNumbers) {

    val numbers = numbers.numbers

    companion object {
        fun of(vararg numbers: Int): LottoTicket {
            return LottoTicket(LottoNumbers.of(*numbers))
        }

        fun of(numbers: List<LottoNumber>): LottoTicket {
            return LottoTicket(LottoNumbers.of(*numbers.map { it.value }.toIntArray()))
        }

        fun of(numbers: LottoNumbers): LottoTicket {
            return LottoTicket(numbers)
        }
    }
}
