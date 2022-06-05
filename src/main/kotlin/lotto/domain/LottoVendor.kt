package lotto.domain

import lotto.util.RandomUtil

class LottoVendor {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        private const val SIZE = 6

        fun generate(lottoCount: Int): List<LottoTicket> {
            return List(lottoCount) { LottoTicket(generateNumbers()) }
        }

        private fun generateNumbers() = RandomUtil.numbersInRange(MINIMUM_NUMBER..MAXIMUM_NUMBER, SIZE)
    }
}
