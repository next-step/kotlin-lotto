package lotto.domain

data class WinningNumber(
    private val _winningNumberList: List<LottoNumber>,
    val bonusNumber: LottoNumber,
) : AbstractLottoTicket(_winningNumberList) {
    init {
        require(bonusNumber !in _winningNumberList) { "Bonus number duplicated in lotto numbers $_winningNumberList $bonusNumber" }
    }
}
