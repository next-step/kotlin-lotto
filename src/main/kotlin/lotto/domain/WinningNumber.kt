package lotto.domain

data class WinningNumber(private var _winningNumberList: List<LottoNumber>) : AbstractLottoTicket(_winningNumberList) {
    fun getResult(lottoTickets: LottoTickets): WinResult = WinResult(lottoTickets, this)
}
