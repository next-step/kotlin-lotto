package lotto.domain

class LottoLines(private val totalNumber: Int) {
    private val lottoLines = createLottoTicket(totalNumber)

    fun checkResult(result: List<Int>, bonusNumber: Int) {
        lottoLines.forEach { it.checkPlace(result, bonusNumber) }
    }

    fun getLines(): List<LottoSingleLine> {
        return lottoLines
    }

    private fun createLottoTicket(totalNumber: Int): List<LottoSingleLine> {
        return (1..totalNumber).toList().map { LottoSingleLine() }
    }
}
