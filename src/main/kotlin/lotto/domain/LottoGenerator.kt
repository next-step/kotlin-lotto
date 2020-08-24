package lotto.domain

private val GAME_MONEY_REGULAR_EXPRESSION = "(\\d*)".toRegex()

object LottoGenerator {
    fun createAutoLottoList(gameMoney: String): List<Lotto> {
        checkValidation(gameMoney)
        return (1..getCountOfGame(gameMoney)).map { Lotto.from() }
    }

    private fun getCountOfGame(gameMoney: String): Int = gameMoney.toInt() / PRICE_OF_LOTTO

    private fun checkValidation(gameMoney: String) {
        require(GAME_MONEY_REGULAR_EXPRESSION.matches(gameMoney)) { "$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요." }
        require(gameMoney.toInt() > PRICE_OF_LOTTO) { "$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요." }
    }
}
