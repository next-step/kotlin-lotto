package lotto.domain

object LottoBuyHelper {

    private val LOTTO_RANGE_NUMBERS = (LottoMachine.MINIMIUM_LOTTO_NUMBER..LottoMachine.MAXIMIUM_LOTTO_NUMBER).map { it }
    private const val LOTTO_NUMBER = 6

    private fun canBuyLotto(money: Int): Boolean {
        return money >= LottoMachine.LOTTERY_PRICE
    }

    fun buyLottoByMachine(amount: Int, lotteriesByHand: LotteryGroup = LotteryGroup()): LotteryGroup {
        val handCount = lotteriesByHand.lotteries.size
        val buyCount = amount / LottoMachine.LOTTERY_PRICE
        if (!canBuyLotto(amount)) {
            throw IllegalArgumentException("값은 1000원 이상을 입력해야 로또를 구매할 수 있음")
        }
        check(buyCount >= handCount) {
            "로또를 살 수 있는 금액보다 수동으로 많은 수를 구매할 수 없습니다. 게임을 다시 실행하세요."
        }
        val numbers = mutableListOf<Lottery>()
        repeat((amount / LottoMachine.LOTTERY_PRICE) - handCount) {
            numbers.add(Lottery(LOTTO_RANGE_NUMBERS.shuffled().take(LOTTO_NUMBER).sorted().map { LottoNumber(it) }))
        }
        return LotteryGroup(numbers)
    }
}
