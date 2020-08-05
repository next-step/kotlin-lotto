package lotto.domain

class LottoLines(private val totalNumber: Int, private val manualNumberList: List<List<Int>>) {
    private val lottoLines = createLottoTicket(totalNumber, manualNumberList)

    fun checkResult(result: List<Int>, bonusNumber: Int) {
        lottoLines.forEach { it.checkPlace(result, bonusNumber) }
    }

    fun getLines(): List<LottoSingleLine> {
        return lottoLines
    }

    private fun createLottoTicket(totalNumber: Int, numbersList: List<List<Int>>): List<LottoSingleLine> {
        val lines = mutableListOf<LottoSingleLine>()
        lines.addAll(numbersList.map { LottoSingleLine(it) })
        lines.addAll((1..(totalNumber - numbersList.size)).toList().map { LottoSingleLine() })
        return lines
    }
}
