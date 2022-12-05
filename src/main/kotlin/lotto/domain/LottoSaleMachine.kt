package lotto.domain

object LottoSaleMachine {
    private const val LOTTO_PRICE = 1000

    fun purchase(purchasePrice: Int): Int {
        require(purchasePrice % LOTTO_PRICE == 0) { "로또 금액은 1000원 단위로 입력할 수 있습니다." }

        return purchasePrice / LOTTO_PRICE
    }
}
