package lotto.domain

object LottoStore {
    fun buy(
        manualLottos: ManualLottos,
        lottoAmount: LottoAmount,
    ): UserLottos {
        val theNumberOfLotto = calculateCountForRandomBuy(lottoAmount, manualLottos)
        val randomLottos =
            (1..theNumberOfLotto).map {
                val lottoNumbers = RandomLottoNumberGenerator.generate()
                Lotto(LottoNumbers(lottoNumbers))
            }

        val lottos = manualLottos + randomLottos
        return UserLottos(lottos = lottos)
    }

    private fun calculateCountForRandomBuy(
        lottoAmount: LottoAmount,
        manualLottos: ManualLottos,
    ): Long {
        val totalPurchasableLottoCount = lottoAmount.calculatePurchasableLottoCount()
        return totalPurchasableLottoCount - manualLottos.size
    }
}
