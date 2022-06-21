package lotto.domain

import lotto.util.RandomUtil

object LottoVendor {
    private const val MINIMUM_NUMBER = 1
    private const val MAXIMUM_NUMBER = 45
    private const val SIZE = 6
    private val NUMBER_RANGE = MINIMUM_NUMBER..MAXIMUM_NUMBER

    fun generate(lottoCount: Int): LottoTickets {
        return LottoTickets(
            List(lottoCount) { LottoTicket(generateNumbers()) }
        )
    }

    private fun generateNumbers() = RandomUtil.getShuffledNumbers(NUMBER_RANGE, SIZE)
}
