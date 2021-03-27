package lotto.store

import lotto.ticket.IssuedLottoTickets
import lotto.ticket.LottoTicket

object LottoStore {
    private const val LOTTO_PRICE = 1000

    fun purchase(request: PurchaseRequest): IssuedLottoTickets {
        val issueCount = request.amount / LOTTO_PRICE

        val manualTickets = issueManualLotto(issueCount = issueCount, txManualLottos = request.txManualLottoTickets)

        val autoTickets = (0 until issueCount - manualTickets.size).map { LottoTicket.ofAuto() }

        return IssuedLottoTickets(manualTickets.plus(autoTickets))
    }

    private fun issueManualLotto(issueCount: Long, txManualLottos: List<String>): List<LottoTicket> {
        require(issueCount >= txManualLottos.size) { "구입 금액${txManualLottos.size}이 부족합니다." }
        return txManualLottos.map {
            LottoTicket.ofManual(it)
        }
    }
}
