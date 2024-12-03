package lotto.model

class Lotto private constructor(private val numbers: List<LottoNumber>) {
    fun getNumbers() = numbers

    fun countMatchingNumbers(winningNumbers: List<LottoNumber>): Int {
        var matchCount = 0
        for (number in winningNumbers) {
            if (numbers.contains(number)) {
                matchCount++
            }
        }
        return matchCount
    }

    companion object {
        private const val PRICE = 1000
        private const val LOTTO_NUMBER_COUNT = 6
        private val numbersMap: Map<Int, LottoNumber> = (1..45).associateWith { LottoNumber(it) }

        fun fromAuto() = Lotto(generateNumbers())

        fun from(lottoNumbers: List<Int>): Lotto {
            require(lottoNumbers.distinct().size == LOTTO_NUMBER_COUNT) { "중복되지 않는 로또 번호 6개를 입력해주세요" }

            val mappedNumbers =
                lottoNumbers.map { number ->
                    numbersMap[number] ?: throw IllegalArgumentException("유효하지 않은 로또 번호 입니다.")
                }

            return Lotto(mappedNumbers)
        }

        fun count(purchaseAmount: Int): Int {
            require(purchaseAmount > 0) { "금액은 양수입니다." }
            return purchaseAmount / PRICE
        }

        private fun generateNumbers(): List<LottoNumber> = numbersMap.values.shuffled().take(6).sortedBy { it.num }
    }
}
