package lotto.domain

class LottoStore {
    fun buyLottoTicket(amount: Int): List<LottoTicket> =
        List(calculateCount(amount)) {
            createAutoLottoTicket()
        }

    private fun calculateCount(amount: Int): Int {
        return amount / LOTTO_PRICE
    }

    private fun createAutoLottoTicket(): LottoTicket {
        val numbers = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).shuffled().take(LOTTO_NUMBER_COUNT).sorted()

        return LottoTicket.of(numbers)
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
