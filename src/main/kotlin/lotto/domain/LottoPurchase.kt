package lotto.domain

class LottoPurchase private constructor(
    val money: Int,
    val manualQuantity: Int
) {
    companion object {
        private val isDigit: (String) -> Boolean = { it.all { char -> char.isDigit() } }

        fun valueOf(money: String, numberOfManualQuantity: String = "0"): LottoPurchase {
            require(isDigit(money) && isDigit(numberOfManualQuantity))
            val manualQuantity = numberOfManualQuantity.toInt()
            val purchaseMoney = money.toInt()
            require(LottoShop.getQuantity(purchaseMoney) >= manualQuantity)

            return LottoPurchase(purchaseMoney, manualQuantity)
        }
    }
}
