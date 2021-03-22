package lotto.view.input

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class ManualLottoInputs(private val manualLottoInputs: List<ManualLottoInput>) {
    val lottoTickets: LottoTickets
        get() = LottoTickets(manualLottoInputs.map { LottoTicket(it.lottoNumbers) })

    constructor() : this(listOf())
}
