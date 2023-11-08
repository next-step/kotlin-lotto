package study.lotto.domain

class Lotto constructor(val numbers: LottoNumbers) {

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
                .let(::LottoNumbers)
                .let(::Lotto)
        }
    }
}
