package lotto.domain

class LottoPurchase private constructor(
    val money: Int,
    val autoQuantity: Int,
    val manualQuantity: Int,
    val manualLottoLines: List<LottoLine>
) {
    companion object {
        private val isDigit: (String) -> Boolean = { it.all { char -> char.isDigit() } }

        fun valueOf(
            money: String,
            numberOfManualQuantity: String = "0",
            manualInputLines: List<String> = emptyList()
        ): LottoPurchase {
            require(isDigit(money) && isDigit(numberOfManualQuantity))
            val manualQuantity = numberOfManualQuantity.toInt()
            val purchaseMoney = money.toInt()
            require(LottoShop.getQuantity(purchaseMoney) >= manualQuantity) {
                "로또 수동 구매 수량은 로또 구입 금액 한도에 맞게 작성하여 주세요."
            }

            val autoQuantity = LottoShop.getQuantity(purchaseMoney)
            require(autoQuantity > LottoShop.ZERO) {
                "${LottoShop.LOTTO_FEE}원 이상 입력하여 주세요."
            }
            val manualLottoLines = manualInputLines.map(LottoLine::valueOf)

            return LottoPurchase(purchaseMoney, autoQuantity, manualQuantity, manualLottoLines)
        }
    }
}
