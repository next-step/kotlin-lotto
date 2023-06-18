package lotto.model

data class WinnerLottoTicket(val lotto: Lotto, val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in lotto) {
            "lottoTicket must not have bonusNumber. but provided lottoTicket(`$lotto`), bonusNumber(`$bonusNumber`)"
        }
    }
}
