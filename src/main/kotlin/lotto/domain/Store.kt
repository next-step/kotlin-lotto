package lotto.domain

object Store {
    fun purchase(price: Int): MutableList<Lotto> {
        validatePurchasePrice(price)

        return issueLottos(price / Policy.LOTTO_PRICE)
    }

    private fun validatePurchasePrice(price: Int) {
        require(price % Policy.LOTTO_PRICE == 0) { "로또 금액은 1000원 단위로 입력할 수 있습니다." }
    }

    private fun issueLottos(count: Int): MutableList<Lotto> {
        return MutableList(count) { LottoGenerator.generate() }
    }
}
