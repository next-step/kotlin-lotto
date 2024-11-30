package lotto.domain

object LottoStore {
    fun buy(money: Int): Lottos {
        if (isValidAmount(money)) throw NotEnoughMoneyException(money)

        val theNumberOfLotto = money / Lotto.MIN_AMOUNT_UNIT
        val lottos = (1..theNumberOfLotto).map {
            val lottoNumbers = RandomLottoNumberGenerator.generate()
            Lotto(lottoNumbers)
        }

        return Lottos(lottos = lottos)
    }

    private fun isValidAmount(money: Int) = money % Lotto.MIN_AMOUNT_UNIT != 0
}
