package lotto.domain

private val GAME_MONEY_REGULAR_EXPRESSION = "(\\d*)".toRegex()

object LottoGenerator {
    fun createAutoLottoList(gameMoneyString: String): List<Lotto> {
        checkValidation(gameMoneyString)
        val count = getCountOfGame(gameMoneyString)
        val generateLottoList = mutableListOf<Lotto>()
        repeat(count) { generateLottoList.add(Lotto.from()) }
        return generateLottoList.toList()
    }

    private fun getCountOfGame(gameMoneyString: String): Int = gameMoneyString.toInt() / PRICE_OF_LOTTO

    private fun checkValidation(gameMoneyString: String) {
        require(GAME_MONEY_REGULAR_EXPRESSION.matches(gameMoneyString)) { "$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요." }
        require(gameMoneyString.toInt() > PRICE_OF_LOTTO) { "$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요." }
    }
}
