package lotto.domain

import lotto.RawLottoNumbers

class LottoMachine {
    fun createLottos(
        amount: Amount,
        manualLottoNumbers: RawLottoNumbers = RawLottoNumbers(),
    ): Lottos {
        val leftAmount = amount.spend(LOTTO_PRICE * manualLottoNumbers.size)
        val manualLottos = manualLottoNumbers.toLottos()
        val autoLottos = createAutoLottos(leftAmount)
        return manualLottos + autoLottos
    }

    private fun createAutoLottos(amount: Amount): Lottos {
        val numberOfAutoLottos = amount.countPurchasable(LOTTO_PRICE)

        return Lottos(
            List(numberOfAutoLottos) {
                Lotto(
                    LottoNumber.cached.shuffled()
                        .take(LOTTO_NUMBERS_SIZE)
                        .map(LottoNumber::from),
                )
            },
        )
    }

    companion object {
        const val LOTTO_PRICE = 1_000
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
