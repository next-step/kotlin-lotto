package lotto.domain

object LottoMachine {
    const val LOTTO_PRICE = 1000

    fun purchase(
        purchaseAmount: Int,
        manualLottery: Lottery,
    ): PurchasedLottery {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE
        val autoLottoCount = numberOfLotto - manualLottery.getCount()
        val autoLottery = Lottery(List(size = autoLottoCount) { Lotto() })

        return PurchasedLottery(
            manualLottery = manualLottery,
            autoLottery = autoLottery
        )
    }
}
