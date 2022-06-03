package lotto.domain

class PurchaseRecord(val lottoList: List<Lotto>) {
    fun findWinnerTypes(winner: Winner): List<WinnerType> {
        return lottoList.mapNotNull { winner.check(it) }
    }

    companion object {
        fun purchase(manualLottos: List<Lotto>, totalLottoCount: Int): PurchaseRecord {
            val autoCount = totalLottoCount - manualLottos.size
            return PurchaseRecord(Lotto.getAutoLotto(autoCount) + manualLottos)
        }
    }
}
