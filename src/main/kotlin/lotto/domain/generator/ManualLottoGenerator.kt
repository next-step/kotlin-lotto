package lotto.domain.generator

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

data class ManualLottoGenerator(private val input: String) : LottoGenerator {

    override fun execute() = LottoTicket(parseNumbers(input).toSortedSet())

    companion object {
        private const val NUMBER_DELIMITER = ","

        private fun parseNumbers(numbers: String) = numbers.split(NUMBER_DELIMITER).map { LottoNumber(it.trim()) }
    }
}
