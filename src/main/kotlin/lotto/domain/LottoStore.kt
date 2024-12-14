package lotto.domain

object LottoStore {
    fun buy(manualLottos: ManualLottos, amount: Amount): UserLottos {
        val theNumberOfLotto = calculateCountForRandomBuy(amount, manualLottos)
        val randomLottos =
            (1..theNumberOfLotto).map {
                val lottoNumbers = RandomLottoNumberGenerator.generate()
                Lotto(LottoNumbers(lottoNumbers))
            }

        val lottos = manualLottos + randomLottos
        return UserLottos(lottos = lottos)
    }

    private fun calculateCountForRandomBuy(amount: Amount, manualLottos: ManualLottos): Int {
        val totalPurchasableLottoCount = amount.calculatePurchasableLottoCount()
        return totalPurchasableLottoCount - manualLottos.size
    }
}
