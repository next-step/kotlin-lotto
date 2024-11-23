package lotto.response

import lotto.domain.LottoLines

class LottoLinesResponse(private val lottoLines: LottoLines) {
    fun toFormattedString(): String {
        return lottoLines.extractLottoLines()
            .joinToString("\n") { line -> line.joinToString(", ", "[", "]") }
    }
}
