package lotto

class LottoShop {
    companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }

    fun sellLotto(money: Money): List<Lotto> {
        if (money.price % LOTTO_UNIT_PRICE != 0) {
            throw IllegalArgumentException("${LOTTO_UNIT_PRICE}원 단위로 입력안됨")
        }

        val lottoCount = money.price / LOTTO_UNIT_PRICE

        return lottoCount.downTo(1).map {
            Lotto()
        }
    }
}
