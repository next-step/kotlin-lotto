package lotto.domain

object LottoStore {
    fun buy(manualLottos: ManualLottos, amount: Int): UserLottos {
        if (isValidAmount(amount)) throw NotEnoughMoneyException(amount)

        val theNumberOfLotto = calculateCountForRandomBuy(amount, manualLottos)
        val randomLottos =
            (1..theNumberOfLotto).map {
                val lottoNumbers = RandomLottoNumberGenerator.generate()
                Lotto(LottoNumbers(lottoNumbers))
            }

        val lottos = manualLottos + randomLottos
        return UserLottos(lottos = lottos)
    }

    private fun calculateCountForRandomBuy(amount: Int, manualLottos: ManualLottos): Int {
        val manualBuyAmount = manualLottos.size * Lotto.MIN_AMOUNT_UNIT
        return (amount - manualBuyAmount) / Lotto.MIN_AMOUNT_UNIT
    }

    private fun isValidAmount(money: Int) = money % Lotto.MIN_AMOUNT_UNIT != 0
}
