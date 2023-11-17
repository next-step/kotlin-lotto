package lotto.business

class LottoBookingSystem(
    private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()
) {
    private fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick(LOTTO_NUMBERS, LOTTO_NUMBER_COUNT)
        return LottoTicket(lottoNumbers)
    }

    fun generateMultipleTickets(purchasableCount: Int): List<LottoTicket> {
        return (1..purchasableCount).map { generateSingleTicket() }
    }

    fun generateManualTickets(manualTicketsNumbers: List<List<Int>>): List<LottoTicket> {
        return LottoTicketGenerator.generateManualTickets(manualTicketsNumbers)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
        private val LOTTO_NUMBERS_MAP =
            (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).map { LottoNumber(it) }.associateBy { it.number }
        val LOTTO_NUMBERS = LOTTO_NUMBERS_MAP.values.toList()

        fun getLottoNumber(value: Int): LottoNumber {
            return LOTTO_NUMBERS_MAP[value] ?: throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.")
        }
    }
}
