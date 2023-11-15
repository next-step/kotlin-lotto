package lotto.business

import lotto.view.LottoInputHandler

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

    fun generateManualTickets(manualCount: Int, purchasableCount: Int): List<LottoTicket> {
        require(purchasableCount >= manualCount) { "구매 가능한 로또 개수보다 많습니다." }
        return LottoTicketGenerator.generateManualTickets(LottoInputHandler.inputManualNumbers(manualCount))
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
