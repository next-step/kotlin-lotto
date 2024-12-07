package lotto.view

object PurchaseLottoView {
    fun inputPurchaseCost(): Int {
        println("구입금액을 입력해 주세요.")
        val inputCost: String? = readlnOrNull()
        requireNotNull(inputCost) { "구입금액이 입력되지 않았습니다" }
        requireNotNull(inputCost.toIntOrNull()) { "구입금액이 올바르게 입력되지 않았습니다" }
        return inputCost.toInt()
    }
}
