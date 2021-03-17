package lotto.domain

class ManualStrategy(
    private val stringManualNumbers: List<List<String>>
) : LottoStrategy {
    override fun generateLotto(quantity: Int): Lottoes {
        return Lottoes(makeManualLottoes(quantity, stringManualNumbers))
    }

    private fun makeManualLottoes(numberOfManual: Int, stringManualNumbers: List<List<String>>): List<LottoTicket> {
        val manualNumbers = stringManualNumbers.map { strings ->
            convertStringToInt(strings)
        }

        return manualNumbers.map { LottoTicket.generateManual(it) }
    }

    private fun convertStringToInt(strings: List<String>): List<Int> {
        return strings.map {
            it.toInt()
        }
    }
}
