package lotto.domain

data class LottoTicket(private var _lottoNumberList: List<LottoNumber>) : AbstractLottoTicket(_lottoNumberList) {
    companion object {
        const val PRICE = 1000
    }
}
