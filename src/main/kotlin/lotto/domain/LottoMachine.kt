package lotto.domain

class LottoMachine {
    fun createLottos(amount: Amount): List<Lotto> {
        val number = amount.divide(LOTTO_PRICE).toInt()
        return List(number) { createAutoLotto() }
    }

    private fun createAutoLotto() =
        Lotto(
            LottoNumber.cached.shuffled()
                .take(LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::from),
        )

    companion object {
        const val LOTTO_PRICE = 1_000
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
