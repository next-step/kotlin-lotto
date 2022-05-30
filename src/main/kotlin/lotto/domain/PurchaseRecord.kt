package lotto.domain

class PurchaseRecord(val lottoList: List<Lotto>) {
    fun findWinners(winnerNumbers: WinnerNumbers): List<Winner> {
        return lottoList.mapNotNull { getWinner(it, winnerNumbers) }
    }

    private fun getWinner(lotto: Lotto, winnerNumbers: WinnerNumbers): Winner? {
        return Winner.values()
            .find { it.matchedNumbers == getMatchedNumbers(lotto, winnerNumbers) }
    }

    private fun getMatchedNumbers(lotto: Lotto, winnerNumbers: WinnerNumbers): Int {
        return winnerNumbers.count { lotto.contains(it) }
    }
}
