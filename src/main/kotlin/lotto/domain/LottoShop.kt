package lotto.domain

class LottoShop {

    fun buyLotto(money: Int): Lotto {
        val quantity = getQuantity(money)
        require(quantity > ZERO) {
            "${LOTTO_FEE}원 이상 입력하여 주세요."
        }
        return Lotto(IntRange(1, quantity).map { LottoGenerator.generate() })
    }

    private fun getQuantity(money: Int) = money / LOTTO_FEE

    companion object {
        const val LOTTO_FEE: Int = 1_000
        const val ZERO: Int = 0
    }
}
