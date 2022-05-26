package lotto

class LottoStore(insertAmount: Int) {

    val ableToPurchaseCount = insertAmount.div(LOTTO_UNIT_PRICE)

    fun purchase(): List<LottoNumber> {
        return List(this.ableToPurchaseCount) { LottoNumberGenerator.autoGenerate() }
    }

    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }
}
