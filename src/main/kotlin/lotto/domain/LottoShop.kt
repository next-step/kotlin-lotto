package lotto.domain

class LottoShop {

    fun buyLotto(purchase: LottoPurchase): Lotto {

        return Lotto(IntRange(1, purchase.autoQuantity).map { LottoGenerator.generate() })
    }

    companion object {
        const val LOTTO_FEE: Int = 1_000
        const val ZERO: Int = 0
        fun getQuantity(money: Int) = money / LOTTO_FEE
    }
}
