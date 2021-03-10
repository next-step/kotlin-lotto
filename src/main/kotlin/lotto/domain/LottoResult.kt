package lotto.domain

class LottoResult {

    fun getMyLottoesRank(lottoes: Lottoes, winningLotto: WinningLotto): Map<Rank, List<LottoTicket>> {
        return lottoes.toList().groupBy { lottoTicket ->
            val countOfMatch = getCountOfMatch(lottoTicket, winningLotto.winningNumbers)
            val bonusMatches = isBonusNumberMatch(lottoTicket, winningLotto.bonusNumber)
            convertCountToRank(countOfMatch, bonusMatches)
        }
    }

    private fun getCountOfMatch(lottoTicket: LottoTicket, prizeNumbers: List<LottoNumber>): Int {
        return lottoTicket.value.count { lottoNumber ->
            prizeNumbers.contains(lottoNumber)
        }
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

    private fun isBonusNumberMatch(lottoTicket: LottoTicket, bonusNumber: LottoNumber): Boolean {
        return lottoTicket.value.contains(bonusNumber)
    }
}
