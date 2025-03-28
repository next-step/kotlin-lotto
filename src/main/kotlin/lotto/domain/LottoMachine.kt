package lotto.domain

class LottoMachine {
    fun createLottos(amount: Amount): List<Lotto> {
        val number = amount.divide(LOTTO_PRICE).toInt()
        return List(number) { createAutoLotto() }
    }

    private fun createAutoLotto() =
        Lotto(
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled()
                .take(LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::from),
        )

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        private const val LOTTO_PRICE = 1_000
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
