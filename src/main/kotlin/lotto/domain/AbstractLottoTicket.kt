package lotto.domain

abstract class AbstractLottoTicket(private var _lottoNumberList: List<LottoNumber>) {
    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid size: ${this.javaClass.name} should have exact 6 numbers: $lottoNumberList")
        }
        require(_lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated number: ${this.javaClass.name} should not have duplicated number: $lottoNumberList")
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
    }
}
