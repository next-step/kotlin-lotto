package lotto.domain

class Lottoes(
    private val value: List<LottoTicket>
) {
    fun getMyLottoesRanks(winningLotto: WinningLotto): LottoesRank {
        return LottoesRank(
            value.groupBy { lottoTicket ->
                winningLotto.getRankOfTicket(lottoTicket)
            }.mapValues {
                it.value.size
            }
        )
    }

    fun toList(): List<LottoTicket> {
        return value.toList()
    }

    operator fun plus(lottoes: Lottoes): Lottoes {
        return Lottoes(value + lottoes.value)
    }
}
