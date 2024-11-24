package lotto

class WinningTicket(val defaultTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(!defaultTicket.contain(bonusNumber)) {
            "보너스 번호는 1등 로또 번호에 포함되지 않아야 합니다: winningTicket=$defaultTicket, bonusNumber=$bonusNumber"
        }
    }

    fun checkTicket(lottoTicket: LottoTicket): WinningResult {
        return WinningResult.valueOf(lottoTicket.countOfMatches(defaultTicket), lottoTicket.contain(bonusNumber))
    }

    fun checkTicketAll(lottoTickets: List<LottoTicket>): List<WinningResult> = lottoTickets.map { checkTicket(it) }
}
