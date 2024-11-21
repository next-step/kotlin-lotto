package lotto.view

object InputView {
    private const val LOTTO_PRICE = 1000

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력하세요.")
        val purchaseAmount = readlnOrNull()?.toInt() ?: 0
        val lottoCount = getLottoCount(purchaseAmount)
        println("${lottoCount}개를 구매했습니다")

        return lottoCount
    }

    private fun getLottoCount(purchaseAmount: Int): Int = (purchaseAmount / LOTTO_PRICE)
}
