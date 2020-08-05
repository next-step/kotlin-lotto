package lotto.domain

import lotto.domain.LottoGenerator.Companion.COUNT
import lotto.domain.LottoGenerator.Companion.MAX
import lotto.domain.LottoGenerator.Companion.MIN

class ManualLottoGenerator(private val numbers: String) : LottoGenerator {

    override fun execute() = numbers.split(DELIMITER).map { it.trim().toInt() }

    companion object {
        private const val DELIMITER = ","

        fun isAcceptable(numbers: String): Boolean {
            val parsedNumbers = numbers.split(DELIMITER).distinct()
            return parsedNumbers.all { it.trim().toIntOrNull() != null && it.toInt() in (MIN..MAX) } && parsedNumbers.size == COUNT
        }
    }
}
