package lotto.domain

class LottoMachine {
    fun createLottos(
        amount: Amount,
        manualLottoNumbers: List<List<Int>> = emptyList(),
    ): List<Lotto> {
        val manualLottos = createManualLottos(amount, manualLottoNumbers)
        val autoLottos = createAutoLottos(amount)
        return manualLottos + autoLottos
    }

    private fun createAutoLottos(amount: Amount): List<Lotto> {
        val numberOfAutoLottos = amount.countPurchasable(LOTTO_PRICE)
        amount.spend(numberOfAutoLottos * LOTTO_PRICE)

        return List(numberOfAutoLottos) {
            Lotto(
                LottoNumber.cached.shuffled()
                    .take(LOTTO_NUMBERS_SIZE)
                    .map(LottoNumber::from),
            )
        }
    }

    private fun createManualLottos(
        amount: Amount,
        manualLottoNumbers: List<List<Int>>,
    ): List<Lotto> {
        amount.spend((LOTTO_PRICE * manualLottoNumbers.size))
        val manualLottos = manualLottoNumbers.map { Lotto(*it.toIntArray()) }
        return manualLottos
    }

    companion object {
        const val LOTTO_PRICE = 1_000
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
