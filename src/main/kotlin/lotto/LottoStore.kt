package lotto

class LottoStore {
    fun sell(money: Int): List<Lotto> {
        if (isValidAmount(money)) throw NotEnoughMoneyException(money)

        val theNumberOfLotto = money / MIN_AMOUNT_UNIT
        return (1..theNumberOfLotto).map {
            val lottoNumbers = RandomLottoNumberGenerator.generate()
            Lotto(lottoNumbers)
        }
    }

    private fun isValidAmount(money: Int) = money % MIN_AMOUNT_UNIT != 0

    companion object {
        private const val MIN_AMOUNT_UNIT = 1000
    }
}
