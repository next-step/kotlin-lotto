package lotto.model.issue

import lotto.model.LottoOrder
import lotto.model.LottoTicket

object LottoIssueMachineManual : LottoIssueMachine {
    override fun buy(lottoOrder: LottoOrder): LottoTicket {
        return LottoTicket(lottoOrder.manualIssuedGames)
    }
}
