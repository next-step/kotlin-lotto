package game.domain.lotto.machine

import game.domain.lotto.Lotto
import game.domain.lotto.LottoTicket

class LottoMachine {
    companion object {
        fun issueLottoAutomatically(count: Long): Lotto {
            return Lotto(LottoTicket.random(count))
        }
    }
}