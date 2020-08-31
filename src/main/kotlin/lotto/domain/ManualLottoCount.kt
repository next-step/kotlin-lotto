package lotto.domain

private val LOTTO_COUNT_REGULAR_EXPRESSION = "(\\d*)".toRegex()

data class ManualLottoCount(val count: Int) {
    companion object {
        fun of(manualLotto: String, gameMoney: LottoGameMoney): ManualLottoCount? {
            if (!LOTTO_COUNT_REGULAR_EXPRESSION.matches(manualLotto)) return null
            val count = manualLotto.toInt()
            if (gameMoney.getCountOfGame() < count) return null
            return ManualLottoCount(count)
        }
    }
}
