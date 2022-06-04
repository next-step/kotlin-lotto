package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.number.LottoNumbers

class LottoTicket private constructor(val numbers: LottoNumbers) {

    companion object {
        fun of(vararg numbers: Int): LottoTicket {
            return LottoTicket(LottoNumbers.of(*numbers))
        }

        fun of(numbers: LottoNumbers): LottoTicket {
            return LottoTicket(numbers)
        }
    }
}
