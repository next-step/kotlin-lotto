package lotto.model

/**
 * 로또를 생성하는 클래스
 * */
class LottoNumberListGenerator(private val price: Price) {
    fun generateLottoList(): List<Lotto> =
        (0 until price.lottoCount)
            .map {
                Lotto(generateRandomNumbers(LottoNumber.getLottoNumberRange().shuffled()))
            }

    companion object {
        private const val NUMBER_START = 0
        private const val NUMBER_END = 6

        fun generateRandomNumbers(range: List<Int>): List<LottoNumber> {
            require(range.size >= 6)
            return (range)
                .subList(NUMBER_START, NUMBER_END)
                .map { LottoNumber(it) }
        }
    }
}
