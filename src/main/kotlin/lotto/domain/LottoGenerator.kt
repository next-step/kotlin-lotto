package lotto.domain

class LottoGenerator {
    fun getLottoCount(payment: Int): Int {
        return payment / LOTTO_PRICE
    }

    fun generateLottoNumbers(): List<LottoNumber> {
        val lottoNumbers = LOTTO_NUMBERS.shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .sorted()
        return lottoNumbers.map { LottoNumber(it) }
    }

    fun generateLottos(count: Int): Lottos {
        val lottos = mutableListOf<LottoNumbers>()
        repeat(count) {
            val lottoNumbers = LottoNumbers(generateLottoNumbers())
            lottos.add(lottoNumbers)
        }
        return Lottos(lottos)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBERS = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
    }
}
