package lotto.domain

object LottoShop {

    const val LOTTO_FEE: Int = 1_000
    const val ZERO: Int = 0
    fun buyLotto(
        purchase: LottoPurchase,
        manualInputLines: List<String> = emptyList()
    ): Lotto {
        val autoLines = makeAutoLottoLine(purchase.autoQuantity)
        val manualLines = makeManualLottoLine(manualInputLines)

        return Lotto(autoLines, manualLines)
    }

    fun getQuantity(money: Int) = money / LOTTO_FEE

    private fun makeAutoLottoLine(autoQuantity: Int): List<LottoLine> =
        IntRange(1, autoQuantity).map { LottoLineGenerator.generate() }

    private fun makeManualLottoLine(manualInputLines: List<String>): List<LottoLine> =
        manualInputLines.map(LottoLine::valueOf)

}
