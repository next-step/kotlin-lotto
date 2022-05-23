package lotto

class LottoPurchase(insertAmount: Int) {

    val ableToPurchaseCount = insertAmount.div(LOTTO_UNIT_PRICE)

    fun purchaseLotto(): List<LottoNumber> {
        return List(this.ableToPurchaseCount) { LottoNumberGenerator.autoGenerate() }
    }

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }
}
