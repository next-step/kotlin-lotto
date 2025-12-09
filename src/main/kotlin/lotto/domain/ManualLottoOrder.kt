package lotto.domain

class ManualLottoOrder(manualCount: ManualCount, val lottos: List<Lotto>) {
    val usedMoney: Money

    init {
        require(lottos.size == manualCount.count) {
            "수동 로또 개수와 입력된 로또 개수가 일치하지 않습니다."
        }
        val manualMoney = manualCount.count * LottoShop.LOTTO_UNIT_PRICE
        usedMoney = Money(manualMoney)
    }
}
