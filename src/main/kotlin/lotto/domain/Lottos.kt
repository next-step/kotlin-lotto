package lotto.domain

data class LottoTicket(
    val lottoNumbers: List<Int>
) {
    fun matchCount(winningNumber: WinningNumber): Int {
        return lottoNumbers.count { lottoNumber ->
            winningNumber.winningNumbers.contains(lottoNumber)
        }
    }
}

data class LottoTickets(
    val lottoCount: Int,
    val lottos: List<Lotto>
)
