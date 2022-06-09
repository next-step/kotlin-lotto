package lotto.domain

import lotto.util.RandomUtil

object LottoVendor {
    private const val MINIMUM_NUMBER = 1
    private const val MAXIMUM_NUMBER = 45
    private const val SIZE = 6

    fun generate(lottoCount: Int): List<LottoTicket> {
        return List(lottoCount) { LottoTicket(generateNumbers()) }
    }

    private fun generateNumbers() = RandomUtil.getShuffledNumbers(MINIMUM_NUMBER..MAXIMUM_NUMBER, SIZE)
}
