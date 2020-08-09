package lotto.domain

import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.LottoGenerator

data class LottoTicket(private val generator: LottoGenerator = AutoLottoGenerator) {
    private val numbers = generator.execute().sorted()

    override fun toString() = "[${numbers.joinToString()}]"

    fun getMatchCount(other: LottoTicket) = numbers.count { other.numbers.contains(it) }
}
