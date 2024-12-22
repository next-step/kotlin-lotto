package lotto.model.price

class Lotto2024Price(
    override val price: Int = 1000,
) : LottoPrice {
    init {
        require(price > 0) {
            "로또 금액 설정이 잘못되었습니다"
        }
    }

    override fun calculateLottoCount(purchaseAmount: Int): Int {
        return purchaseAmount.div(price)
    }
}
