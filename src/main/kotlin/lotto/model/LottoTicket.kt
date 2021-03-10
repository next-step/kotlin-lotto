package lotto.model

import lotto.model.LottoNumber.Companion.NUMBERS_MAXIMUM
import lotto.model.LottoNumbers.Companion.NUMBERS_SIZE

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
