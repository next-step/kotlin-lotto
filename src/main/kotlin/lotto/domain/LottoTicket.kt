package lotto.domain

data class LottoTicket(private val _lottoNumberList: List<LottoNumber>) : AbstractLottoTicket(_lottoNumberList) {
    fun getRank(winningNumber: WinningNumber): Rank {
        return Rank.ofCount(_lottoNumberList.count { it in winningNumber.lottoNumberList })
    }

    companion object {
        const val PRICE = 1000
    }
}
