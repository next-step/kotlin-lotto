package lotto.domain

import lotto.domain.Money.Companion.LOTTO_COST

class ManualStrategy(
    private val stringManualNumbers: List<List<String>>
) : LottoStrategy {
    override fun generateLotto(money: Money): Lottoes {
        val numberOfManual = stringManualNumbers.size
        money.spendMoney(LOTTO_COST * numberOfManual)
        return Lottoes(makeManualLottoes(numberOfManual, stringManualNumbers))
    }

    private fun makeManualLottoes(numberOfManual: Int, stringManualNumbers: List<List<String>>): List<LottoTicket> {
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }

        return manualNumbers.map { LottoTicket(it) }
    }

    private fun convertStringToInt(strings: List<String>): List<Int> {
        return strings.map {
            it.toInt()
        }
    }
}
