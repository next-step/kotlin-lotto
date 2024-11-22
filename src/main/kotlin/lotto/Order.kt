package lotto

class Order(
    val amount: Int,
    numberGenerator: NumberGenerator = LottoNumberGenerator(),
) {
    val lottos: List<Lotto>

    init {
        validatePositive()
        val lottoCount = calculateLottoCounts()
        lottos = List(lottoCount) { Lotto(numberGenerator.generate()) }
    }

    private fun validatePositive() {
        require(amount > 0) { "로또 구매 금액은 음수이거나 0원일 수 없습니다. (현재 입력 금액: $amount)" }
    }

    private fun calculateLottoCounts(): Int {
        require(amount % UNIT_OF_AMOUNT == 0) { "로또 구매 금액은 1000원 단위로 입력되어야 합니다. (현재 입력 금액: $amount)" }
        return amount / UNIT_OF_AMOUNT
    }

    companion object {
        private const val UNIT_OF_AMOUNT = 1000
    }
}
