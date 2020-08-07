package lotto.domain

class LottoLines(totalNumber: Int, numbersList: List<LottoSingleLine>) {
    private val lottoLines = createLottoTicket(totalNumber, numbersList)

    fun checkResult(result: List<Int>, bonusNumber: Int) {
        lottoLines.forEach { it.checkPlace(result, bonusNumber) }
    }

    fun getLines(): List<LottoSingleLine> {
        return lottoLines
    }

    private fun createLottoTicket(totalNumber: Int, numbersList: List<LottoSingleLine>): List<LottoSingleLine> {
        val lines = mutableListOf<LottoSingleLine>()
        lines.addAll(numbersList)
        lines.addAll((1..(totalNumber - numbersList.size)).toList().map { LottoSingleLine() })
        return lines
    }
}
