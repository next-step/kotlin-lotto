package lotto

import lotto.InputView.DELIMITER
import kotlin.math.roundToInt

object LottoProgram {
    private const val UNIT = 1000
    private const val MIN_MATCH_COUNT = 3
    private const val DECIMAL_STANDARD = 100.0

    fun getAmountOfLotto(amountOfMoney: Int): Int {
        validateMoneyUnit(amountOfMoney)
        return amountOfMoney / UNIT
    }

    fun getWinningNumbers(winningNumbers: String): WinningNumbers {
        val numbers = winningNumbers.replace(" ", "")
            .split(DELIMITER)
            .map { it.toInt() }
        validateDuplicatedNumber(numbers)
        return WinningNumbers(numbers)
    }

    fun matchLottos(lottos: Lottos, winningLotto: WinningNumbers): List<Rank> {
        val results = mutableListOf<Rank>()
        lottos.lottos.forEach {
            val count = matchLotto(it, winningLotto.winningNumbers)
            results.add(Rank.of(count))
        }
        return results.toList()
    }

    fun calculateRateOfReturn(results: List<Rank>, amountOfMoney: Int): Double {
        val results = results.sumBy { it.prize }
        if (results == 0) return 0.0
        return (results / amountOfMoney.toDouble() * DECIMAL_STANDARD).roundToInt() / DECIMAL_STANDARD
    }

    private fun matchLotto(userLotto: Lotto, winningLotto: List<Int>): Int {
        val count = userLotto.lotto.filter { winningLotto.contains(it) }.count()
        if (count < MIN_MATCH_COUNT) return 0
        return count
    }

    private fun validateMoneyUnit(amountOfMoney: Int) {
        if (amountOfMoney % UNIT != 0 || amountOfMoney == 0) {
            throw UnitException("1000원 단위만 입력할 수 있습니다.")
        }
    }

    private fun validateDuplicatedNumber(numbers: List<Int>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
        }
    }
}
