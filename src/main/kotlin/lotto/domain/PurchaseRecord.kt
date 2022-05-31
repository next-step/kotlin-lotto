package lotto.domain

class PurchaseRecord(val lottoList: List<Lotto>) {
    fun findWinnerTypes(winner: Winner): List<WinnerType> {
        return lottoList.mapNotNull { getWinner(it, winner) }
    }

    private fun getWinner(lotto: Lotto, winner: Winner): WinnerType? {
        return WinnerType.valueOf(
            lotto.countMatchedNumbers(winner.lotto),
            lotto.contains(winner.bonusNumber)
        )
    }
}
