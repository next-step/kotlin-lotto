package lotto

class LottoStore {
    private val lottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()

    fun sell(money: Int): List<Lotto> {
        if (isValidAmount(money)) throw NotEnoughMoneyException(money)

        val theNumberOfLotto = money / MIN_AMOUNT_UNIT
        return (1..theNumberOfLotto).map {
            val shuffledLottoNumbers = lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT)
            Lotto(shuffledLottoNumbers)
        }
    }

    private fun isValidAmount(money: Int) = money % MIN_AMOUNT_UNIT != 0

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6

        private const val MIN_AMOUNT_UNIT = 1000
    }
}