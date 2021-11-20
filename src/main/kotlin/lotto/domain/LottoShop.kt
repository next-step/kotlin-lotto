package lotto.domain

object LottoShop {
    private const val LOTTO_PRICE = 1000
    fun exchangeMoneyForLotto(input: Int): Lotto {
        return Lotto(calculate(input))
    }

    fun calculate(input: Int) = input / LOTTO_PRICE
}
