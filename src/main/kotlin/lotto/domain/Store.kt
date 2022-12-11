package lotto.domain

object Store {

    private const val PRICE_OF_ONE_GAME = 1000

    fun buy(purchase: Int): List<Lottery> {
        require(purchase > 0) { throw IllegalArgumentException("구입 금액은 0보다 커야합니다.") }
        require(isLotteryPrice(purchase)) { throw IllegalArgumentException("구입 금액은 1000원 단위로 입력해주세요.") }

        return List(purchase / PRICE_OF_ONE_GAME) {
            RandomLotteryGenerator.run()
        }
    }

    private fun isLotteryPrice(purchase: Int): Boolean = (purchase % PRICE_OF_ONE_GAME == 0) && (purchase > 0)
}
