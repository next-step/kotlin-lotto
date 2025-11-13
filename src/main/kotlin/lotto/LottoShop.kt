package lotto

class LottoShop {
    companion object {
        private const val LOTTO_UNIT_PRICE = 1000
    }

    fun buyLotto(price: Int): Int {
        if (price % LOTTO_UNIT_PRICE != 0) {
            throw IllegalArgumentException("1000원 단위로 입력안됨")
        }

        return price / LOTTO_UNIT_PRICE
    }
}
