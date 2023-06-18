package lotto.domain

object LottoBuyHelper {

    private val LOTTO_RANGE_NUMBERS = (LottoMachine.MINIMIUM_LOTTO_NUMBER..LottoMachine.MAXIMIUM_LOTTO_NUMBER).map { it }
    private const val LOTTO_NUMBER = 6

    private fun canBuyLotto(money: Int): Boolean {
        return money >= LottoMachine.LOTTERY_PRICE
    }

    fun buyLotto(amount: Int): LotteryGroup {
        if (!canBuyLotto(amount)) {
            throw IllegalArgumentException("값은 1000원 이상을 입력해야 로또를 구매할 수 있음")
        }
        val numbers = mutableListOf<Lottery>()
        repeat(amount / LottoMachine.LOTTERY_PRICE) {
            numbers.add(Lottery(LOTTO_RANGE_NUMBERS.shuffled().take(LOTTO_NUMBER).sorted().map { LottoNumber(it) }))
        }
        return LotteryGroup(numbers)
    }
}
