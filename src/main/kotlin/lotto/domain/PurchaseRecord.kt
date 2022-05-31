package lotto.domain

class PurchaseRecord(val lottoList: List<Lotto>) {
    fun findWinnerTypes(winner: Winner): List<WinnerType> {
        return lottoList.mapNotNull { winner.check(it) }
    }
}
