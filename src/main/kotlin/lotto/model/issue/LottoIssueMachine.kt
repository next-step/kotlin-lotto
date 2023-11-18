package lotto.model.issue

import lotto.model.LottoOrder
import lotto.model.LottoTicket

interface LottoIssueMachine {
    fun buy(lottoOrder: LottoOrder): LottoTicket
}
