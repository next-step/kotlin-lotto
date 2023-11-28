package lotto.domain

data class WinningNumber(
    private val _lottoTicket: LottoTicket,
    val bonusNumber: LottoNumber,
) {
    val lottoNumberList get() = _lottoTicket.lottoNumberList

    init {
        require(bonusNumber !in _lottoTicket.lottoNumberList) { "Bonus number duplicated in lotto numbers ${_lottoTicket.lottoNumberList} $bonusNumber" }
    }
}
