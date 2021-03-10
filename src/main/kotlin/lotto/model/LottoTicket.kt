package lotto.model

data class LottoTicket(val numbers: LottoNumbers = autoCreate()) {
    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    fun countMatch(winningNumbers: WinningNumbers): Int {
        return winningNumbers.count {
            numbers.contains(it)
        }
    }

    companion object {
        private const val NUMBERS_MAXIMUM = 45
        private const val NUMBERS_SIZE = 6

        private fun autoCreate() =
            LottoNumbers.from(
                List(NUMBERS_MAXIMUM) { i -> i + 1 }
                    .shuffled()
                    .subList(0, NUMBERS_SIZE)
                    .sorted()
            )

        fun from(numbers: List<Int>): LottoTicket {
            return LottoTicket(LottoNumbers.from(numbers))
        }
    }
}
