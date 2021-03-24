package lotto.view.input

class AmountInput(input: String?) {
    val lottoCount: Int

    init {
        require(!input.isNullOrBlank()) { "구입금액은 공백이거나 null일수 없습니다" }
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("구임금액은 숫자여야 합니다.")
        require(amount >= PER_LOTTO_PRICE) { "최소 금액은 $PER_LOTTO_PRICE 이상 이어야 합니다." }

        lottoCount = amount / PER_LOTTO_PRICE
    }

    constructor(input: Int) : this(input.toString())

    companion object {
        private const val PER_LOTTO_PRICE = 1000
    }
}
