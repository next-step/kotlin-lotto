package study.lotto.domain

class Lotto private constructor(val numbers: List<LottoNumber>) {

    fun list() = numbers.toList()
    fun toIntList() = numbers.map { it.number }

    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT) {
            "A Lotto must have exactly 6 numbers, but got ${numbers.size}"
        }
    }

    fun countMatches(winningNumbers: Lotto): Int {
        return this.numbers.count(winningNumbers.numbers::contains)
    }

    companion object {
        const val LOTTO_NUMBERS_COUNT = 6
        const val PRICE_PER_TICKET = 1_000

        fun generate(): Lotto {
            return LottoNumber.getLottoNumbers()
                .take(6)
                .sorted()
                .let(::Lotto)
        }

        fun generate(numbers: List<LottoNumber>): Lotto = numbers.sorted().let(::Lotto)
    }
}
