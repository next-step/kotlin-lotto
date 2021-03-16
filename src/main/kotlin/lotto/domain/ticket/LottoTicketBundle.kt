package lotto.domain.ticket

import lotto.domain.result.LottoResult

class LottoTicketBundle {
    var manualLottoTickets: LottoTickets? = null
    var automaticLottoTickets: LottoTickets? = null
    var allTickets: LottoTickets = LottoTickets.empty()

    fun addManualLottoTickets(lottoTickets: LottoTickets) {
        this.manualLottoTickets = lottoTickets
        merge(lottoTickets)
    }

    fun addAutomaticLottoTickets(lottoTickets: LottoTickets) {
        this.automaticLottoTickets = lottoTickets
        merge(lottoTickets)
    }

    private fun merge(lottoTickets: LottoTickets) {
        this.allTickets.run {
            this.merge(lottoTickets)
        }
    }

    fun manualSize() = manualLottoTickets?.size() ?: NOT_EXIST

    fun automaticSize() = automaticLottoTickets?.size() ?: NOT_EXIST

    fun tickets() = allTickets.tickets

    fun compare(winningLotto: WinningLotto): LottoResult {
        return allTickets.compare(winningLotto)
    }

    companion object {
        private const val NOT_EXIST = 0
    }
}
