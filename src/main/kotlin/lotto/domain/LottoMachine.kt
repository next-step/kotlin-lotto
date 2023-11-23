package lotto.domain

object LottoMachine {
    fun purchase(
        purchaseAmount: Int,
        manualLottery: Lottery,
    ): PurchasedLottery {
        val numberOfLotto = purchaseAmount / LottoPolicy.PRICE
        val autoLottoCount = numberOfLotto - manualLottery.getCount()
        val autoLottery = Lottery(List(size = autoLottoCount) { Lotto() })

        return PurchasedLottery(
            manualLottery = manualLottery,
            autoLottery = autoLottery
        )
    }
}
