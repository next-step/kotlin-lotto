package lotto.domain

data class LottoTicket(private var _lottoNumberList: List<LottoNumber>) {

    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            "Invalid size: ${this.javaClass.name} should have exact 6 numbers: $lottoNumberList"
        }
        require(_lottoNumberList.toSet().size == 6) {
            "Duplicated number: ${this.javaClass.name} should not have duplicated number: $lottoNumberList"
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
    }

    fun getRank(winningNumber: WinningNumber): Rank {
        return Rank.of(
            _lottoNumberList.count { it in winningNumber.lottoNumberList },
            _lottoNumberList.contains(winningNumber.bonusNumber)
        )
    }

    companion object {
        const val PRICE = 1000
    }
}
