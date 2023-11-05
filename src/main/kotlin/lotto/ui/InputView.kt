package lotto.ui

object InputView {
    fun getPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = readlnOrNull()
        requireNotNull(purchaseAmount) {
            "구매 금액은 null을 허용하지 않습니다."
        }
        return purchaseAmount
    }
}