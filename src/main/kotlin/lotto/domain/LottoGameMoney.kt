package lotto.domain

const val PRICE_OF_LOTTO = 1000
private val GAME_MONEY_REGULAR_EXPRESSION = "(\\d*)".toRegex()

data class LottoGameMoney(val lottoGameMoney: Int) {

    fun getCountOfGame(): Int = lottoGameMoney / PRICE_OF_LOTTO

    companion object {
        fun from(lottoGameMoney: String): LottoGameMoney? {
            if (!GAME_MONEY_REGULAR_EXPRESSION.matches(lottoGameMoney)) return null
            if (lottoGameMoney.toInt() < PRICE_OF_LOTTO) return null
            return LottoGameMoney(lottoGameMoney.toInt())
        }
    }
}
