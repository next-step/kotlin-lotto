package next.step.lotto.domain

@JvmInline
value class LottoWinningNumbers(val numbers: Set<LottoNumber>) {
    
    init {
        require(numbers.size == WINNING_NUMBER_CNT) { "당첨 번호는 6개여야 합니다." }
    }

    fun size(): Int = numbers.size

    companion object {
        private const val WINNING_NUMBER_CNT = 6
        fun of(numbers: Set<LottoNumber>): LottoWinningNumbers {
            return LottoWinningNumbers(numbers)
        }

        fun from(numbers: Set<Int>): LottoWinningNumbers {
            return LottoWinningNumbers(numbers.map { LottoNumber.of(it) }.toSet())
        }
    }
}