package lotto.domain

object LottoShop {

    const val LOTTO_FEE: Int = 1_000
    const val ZERO: Int = 0
    fun buyLotto(
        purchase: LottoPurchase,
        manualLottoLines: List<LottoLine> = emptyList()
    ): Lotto {
        val autoLine = makeAutoLottoLine(purchase.autoQuantity)
        return Lotto(autoLine, manualLottoLines)
    }

    fun getQuantity(money: Int) = money / LOTTO_FEE

    private fun makeAutoLottoLine(autoQuantity: Int): List<LottoLine> =
        IntRange(1, autoQuantity).map { LottoLineGenerator.generate() }
}
