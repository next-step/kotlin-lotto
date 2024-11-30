package lotto.domain

object LottoStore {
    fun sell(money: Int): List<Lotto> {
        if (isValidAmount(money)) throw NotEnoughMoneyException(money)

        val theNumberOfLotto = money / Lotto.MIN_AMOUNT_UNIT
        return (1..theNumberOfLotto).map {
            val lottoNumbers = RandomLottoNumberGenerator.generate()
            Lotto(lottoNumbers)
        }
    }

    private fun isValidAmount(money: Int) = money % Lotto.MIN_AMOUNT_UNIT != 0
}
