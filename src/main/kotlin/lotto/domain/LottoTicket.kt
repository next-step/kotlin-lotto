package lotto.domain

class LottoTicket private constructor(private val numbers: List<Int>) {

    fun getLottoNumbers(): List<Int> {
        return numbers.toList()
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        fun generateAuto(): LottoTicket {
            val numbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().slice(0..5)
            return LottoTicket(numbers.sorted())
        }

        fun generateManual(numbers: List<Int>): LottoTicket {
            return LottoTicket(numbers.sorted())
        }
    }
}
