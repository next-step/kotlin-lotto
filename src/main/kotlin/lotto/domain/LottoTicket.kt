package lotto.domain

class LottoTicket private constructor(val numbers: Set<Int> = HashSet()) {
    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun create(): LottoTicket {
            val numbers = HashSet<Int>()
            while (numbers.size != LOTTO_NUMBER_COUNT) {
                numbers.add((MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).random())
            }
            return LottoTicket(numbers)
        }
    }
}
