package lotto.model

data class WinnerLottoTicket(val lottoTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in lottoTicket) {
            "lottoTicket must not have bonusNumber. but provided lottoTicket(`$lottoTicket`), bonusNumber(`$bonusNumber`)"
        }
    }
}
