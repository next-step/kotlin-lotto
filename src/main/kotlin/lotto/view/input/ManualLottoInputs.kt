package lotto.view.input

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

data class ManualLottoInputs(private val manualLottoInputs: List<ManualLottoInput>) :
    List<ManualLottoInput> by manualLottoInputs {

    val lottoTickets: LottoTickets = LottoTickets(map { LottoTicket(it) })

    constructor() : this(listOf())
}
