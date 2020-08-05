package lotto.domain

class LottoLines(private val totalNumber: Int, private val manualNumberList: ManualLotto) {
    private val lottoLines = createLottoTicket(totalNumber, manualNumberList)

    fun checkResult(result: List<Int>, bonusNumber: Int) {
        lottoLines.forEach { it.checkPlace(result, bonusNumber) }
    }

    fun getLines(): List<LottoSingleLine> {
        return lottoLines
    }

    private fun createLottoTicket(totalNumber: Int, numbersList: ManualLotto): List<LottoSingleLine> {
        val lines = mutableListOf<LottoSingleLine>()
        val numbersList = numbersList.getAll()
        lines.addAll(numbersList.map { LottoSingleLine(it) })
        lines.addAll((1..(totalNumber - numbersList.size)).toList().map { LottoSingleLine() })
        return lines
    }
}
