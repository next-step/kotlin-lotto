package lotto.domain

object LottoStore {
    private const val MAX_LOTTO_NUMBER_COUNT = 6

    fun purchase(money: Int): List<Lotto> {
        val count = money / Lotto.LOTTO_PRICE
        return List(count) { generateRandomLotto() }
    }

    private fun generateRandomLotto(): Lotto {
        val lottoNumbers = LottoNumbers.LOTTO_NUMBERS.shuffled().take(MAX_LOTTO_NUMBER_COUNT)
        return Lotto.fromLottoNumbers(lottoNumbers)
    }
}
