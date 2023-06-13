package next.step.lotto.domain

@JvmInline
value class LottoWinningNumbers(private val numbers: Set<LottoNumber>) : Set<LottoNumber> by numbers {
    companion object {
        fun from(str: String): LottoWinningNumbers {
            val numbers = parse(str)
            require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
            return LottoWinningNumbers(numbers)
        }

        private fun parse(str: String) = str.split(",")
            .map { LottoNumber.of(it.trim().toInt()) }
            .toSet()
    }
}