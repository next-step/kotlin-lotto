package lotto.domain

data class LottoTicket(private var _lottoNumberList: List<LottoNumber>) {
    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid size: lotto numbers should have exact 6 numbers: $lottoNumberList")
        }
        require(_lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated number: lotto numbers should not have duplicated number: $lottoNumberList")
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
    }
}
