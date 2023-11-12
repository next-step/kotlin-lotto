package lotto.domain

class LottoShop {

    fun buyLotto(purchase: LottoPurchase): Lotto {
        val quantity = getQuantity(purchase.money)
        require(quantity > ZERO) {
            "${LOTTO_FEE}원 이상 입력하여 주세요."
        }
        return Lotto(IntRange(1, quantity).map { LottoGenerator.generate() })
    }

    companion object {
        const val LOTTO_FEE: Int = 1_000
        const val ZERO: Int = 0
        fun getQuantity(money: Int) = money / LOTTO_FEE
    }
}
