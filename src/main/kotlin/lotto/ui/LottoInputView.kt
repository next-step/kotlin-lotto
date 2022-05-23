package lotto.ui

object LottoInputView {
    private const val ONE_LOTTO_PRICE = 1000

    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = readln().toIntOrNull() ?: throw RuntimeException("")

        return purchaseAmount / ONE_LOTTO_PRICE
    }
}
