package lotto.filter

object LottoMoneyFilter : Filter {

    private const val LOTTO_PRICE = 1_000
    private const val LOTTO_PRICE_ERROR_MESSAGE = "로또의 구매 단위는 1000 단위 입니다."
    private const val LOTTO_MIN_MONEY = 0
    private const val LACK_MONEY_MESSAGE = "금액이 부족 합니다."

    override fun verify(value: Int): Int {
        require(value % LOTTO_PRICE == 0) { IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE) }
        require(value > LOTTO_MIN_MONEY) { IllegalArgumentException(LACK_MONEY_MESSAGE) }

        return value / LOTTO_PRICE
    }
}
