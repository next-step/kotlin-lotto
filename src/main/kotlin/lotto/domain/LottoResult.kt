package lotto.domain

class LottoResult {

    fun getMyLottoesRank(lottoes: Lottoes, winningLotto: WinningLotto): List<Rank> {
        return lottoes.toList().map { lotto ->
            val countOfMatch = getCountOfMatch(lotto, winningLotto.winningNumbers)
            val bonusMatches = isBonusNumberMatch(lotto, winningLotto.bonusNumber)
            convertCountToRank(countOfMatch, bonusMatches)
        }
    }

    private fun getCountOfMatch(lottoTicket: LottoTicket, prizeNumbers: List<Int>): Int {
        return lottoTicket.getLottoNumbers().filter { number ->
            prizeNumbers.contains(number)
        }.size
    }

    private fun convertCountToRank(countOfMatch: Int, bonusMatches: Boolean): Rank {
        return when {
            countOfMatch == 6 -> {
                Rank.FIRST
            }
            countOfMatch == 5 && bonusMatches -> {
                Rank.SECOND
            }
            countOfMatch == 5 -> {
                Rank.THIRD
            }
            countOfMatch == 4 -> {
                Rank.FOURTH
            }
            countOfMatch == 3 -> {
                Rank.FIFTH
            }
            else -> {
                Rank.MISS
            }
        }
    }

    private fun isBonusNumberMatch(lottoTicket: LottoTicket, bonusNumber: Int): Boolean {
        return lottoTicket.getLottoNumbers().contains(bonusNumber)
    }
}
