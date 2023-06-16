package lotto.domain

object LottoBuyHelper {

    private val LOTTO_RANGE_NUMBERS = (LottoMachine.MINIMIUM_LOTTO_NUMBER..LottoMachine.MAXIMIUM_LOTTO_NUMBER).map { it }
    private const val LOTTO_NUMBER = 6
    private const val LOTTO_PRICE = 1000

    private var myAmount = 0

    private fun canBuyLotto(money: Int): Boolean {
        return money >= LOTTO_PRICE
    }

    fun buyLotto(amount: Int): LottoNumbers {
        if (!canBuyLotto(amount)) {
            throw IllegalArgumentException("값은 1000원 이상을 입력해야 로또를 구매할 수 있음")
        }
        myAmount = amount
        val numbers = mutableListOf<LottoNumber>()
        repeat(amount / LOTTO_PRICE) {
            numbers.add(LottoNumber(LOTTO_RANGE_NUMBERS.shuffled().take(LOTTO_NUMBER).sorted()))
        }
        return LottoNumbers(numbers)
    }
}
