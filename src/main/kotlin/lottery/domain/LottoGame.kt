package lottery.domain

class LottoGame(
    val amount: Int,
) {

    companion object {
        private const val LOTTERY_PRICE = 1000
    }
}
