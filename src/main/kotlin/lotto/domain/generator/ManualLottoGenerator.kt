package lotto.domain.generator

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType

data class ManualLottoGenerator(private val input: String) : LottoGenerator {

    override fun execute() = LottoTicket(
        LottoType.MANUAL,
        parseNumbers(input).toSortedSet()
    )

    companion object {
        private const val NUMBER_DELIMITER = ","

        private fun parseNumbers(numbers: String) =
            numbers.split(NUMBER_DELIMITER).map { LottoNumber(it.trim().toInt()) }
    }
}
