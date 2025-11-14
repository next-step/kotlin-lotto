package lotto

class LottoShop {
    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }

    fun buyLotto(money: Money): Int {
        if (money.price % LOTTO_UNIT_PRICE != 0) {
            throw IllegalArgumentException("1000원 단위로 입력안됨")
        }

        return money.price / LOTTO_UNIT_PRICE
    }
}
