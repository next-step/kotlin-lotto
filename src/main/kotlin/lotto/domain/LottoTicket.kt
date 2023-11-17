package lotto.domain

data class LottoTicket(private var _lottoNumberList: List<LottoNumber>) : AbstractLottoTicket(_lottoNumberList) {
    companion object {
        val price = 1000
    }
}
