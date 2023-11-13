package lotto

data class LottoTicket(val numbers: List<Int>) {

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val MAIN_LOTTO_NUMBERS_COUNT = 6
        private val LOTTO_NUMBERS = (MINIMUM_NUMBER..MAXIMUM_NUMBER).toList()

        fun generate(): LottoTicket {
            val lottoNumbers = LOTTO_NUMBERS.shuffled().take(MAIN_LOTTO_NUMBERS_COUNT).sorted()
            return LottoTicket(lottoNumbers)
        }
    }
}
