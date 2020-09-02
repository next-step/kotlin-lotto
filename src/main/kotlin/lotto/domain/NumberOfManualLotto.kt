package lotto.domain

private val LOTTO_COUNT_REGULAR_EXPRESSION = "(\\d*)".toRegex()

data class NumberOfManualLotto(val count: Int) {

    operator fun minus(value: Int): NumberOfManualLotto = NumberOfManualLotto(this.count - value)

    companion object {
        fun of(manualLotto: String, gameMoney: LottoGameMoney): NumberOfManualLotto? {
            if (!LOTTO_COUNT_REGULAR_EXPRESSION.matches(manualLotto)) return null
            val count = manualLotto.toInt()
            if (gameMoney.getCountOfGame() < count) return null
            return NumberOfManualLotto(count)
        }
    }
}
