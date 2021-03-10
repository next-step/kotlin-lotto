package lotto.domain

class LottoResult {

    fun getMyLottoesRank(lottoes: Lottoes, winningLotto: WinningLotto): Map<Rank, List<LottoTicket>> {
        return lottoes.toList().groupBy { lottoTicket ->
            val countOfMatch = lottoTicket.getCountOfMatch(winningLotto.winningNumbers)
            val bonusMatches = isBonusNumberMatch(lottoTicket, winningLotto.bonusNumber)
            convertCountToRank(countOfMatch, bonusMatches)
        }
    }

    private fun convertCountToRank(countOfMatch: Int, bonusMatches: Boolean): Rank {
        if (countOfMatch == 6) return Rank.FIRST
        if (countOfMatch == 5 && bonusMatches) return Rank.SECOND
        if (countOfMatch == 5) return Rank.THIRD
        if (countOfMatch == 4) return Rank.FOURTH
        if (countOfMatch == 3) return Rank.FIFTH
        return Rank.MISS
    }

    private fun isBonusNumberMatch(lottoTicket: LottoTicket, bonusNumber: LottoNumber): Boolean {
        return lottoTicket.value.contains(bonusNumber)
    }
}
