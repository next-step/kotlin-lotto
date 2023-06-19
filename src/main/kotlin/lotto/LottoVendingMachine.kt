package lotto

object LottoVendingMachine {
    private const val LOTTO_PRICE = 1000

    fun buyLotto(money: Int?): List<Lotto> {
        requireNotNull(money) {
            "구매 금액은 null이 아니어야 함"
        }
        require(money >= LOTTO_PRICE) {
            "구매 금액은 1000 보다 커야 함"
        }

        return List(money / LOTTO_PRICE) { Lotto.makeLotto() }
    }
}
