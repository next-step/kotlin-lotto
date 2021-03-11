package lotto.model

import lotto.model.LottoNumber.Companion.NUMBERS_MAXIMUM
import lotto.model.LottoNumbers.Companion.NUMBERS_SIZE

data class LottoTicket(val numbers: LottoNumbers = autoCreate()) {
    fun countMatch(winningNumbers: WinningNumbers): Int {
        return winningNumbers.count {
            numbers.contains(it)
        }
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }

    companion object {
        private fun autoCreate() =
            LottoNumbers(
                List(NUMBERS_MAXIMUM) { i -> i + 1 }
                    .shuffled()
                    .subList(0, NUMBERS_SIZE)
            )

        fun from(numbers: List<Int>): LottoTicket {
            return LottoTicket(LottoNumbers(numbers))
        }
    }
}
