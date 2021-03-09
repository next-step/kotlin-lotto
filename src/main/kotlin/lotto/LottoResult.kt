package lotto

class LottoResult {

    fun getMyLottoesRank(lottoes: Lottoes, prizeNumbers: List<Int>, bonusNumber: Int): List<Rank> {
        return lottoes.toList().map { lotto ->
            val countOfMatch = getCountOfMatch(lotto, prizeNumbers)
            val bonusMatches = isBonusNumberMatch(lotto, bonusNumber)
            convertCountToRank(countOfMatch, bonusMatches)
        }
    }

    private fun getCountOfMatch(lotto: Lotto, prizeNumbers: List<Int>): Int {
        return lotto.getLottoNumbers().filter { number ->
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

    private fun isBonusNumberMatch(lotto: Lotto, bonusNumber: Int): Boolean {
        return lotto.getLottoNumbers().contains(bonusNumber)
    }
}
