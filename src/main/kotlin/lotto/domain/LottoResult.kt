package lotto.domain

class LottoResult {

    fun getMyLottoesRank(lottoes: Lottoes, winningLotto: WinningLotto): LottoesRank {
        return LottoesRank(lottoes.toList().groupBy { lottoTicket ->
            val countOfMatch = lottoTicket.getCountOfMatch(winningLotto.winningNumbers)
            val bonusMatches = isBonusNumberMatch(lottoTicket, winningLotto.bonusNumber)
            convertCountToRank(countOfMatch, bonusMatches)
        })
    }

    private fun convertCountToRank(countOfMatch: Int, bonusMatch: Boolean): Rank {
        return Rank.valueOf(countOfMatch, bonusMatch)
    }

    private fun isBonusNumberMatch(lottoTicket: LottoTicket, bonusNumber: LottoNumber): Boolean {
        return lottoTicket.value.contains(bonusNumber)
    }
}
