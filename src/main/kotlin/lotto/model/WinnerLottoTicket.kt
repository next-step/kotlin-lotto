package lotto.model

data class WinnerLottoTicket(val lottoTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(!lottoTicket.has(bonusNumber)) {
            "lottoTicket must not have bonusNumber. but provided lottoTicket(`$lottoTicket`), bonusNumber(`$bonusNumber`)"
        }
    }
}
