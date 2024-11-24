package lotto.domain

class LottoLines(private val lines: List<LottoLine>) {
    init {
        require(lines.isNotEmpty()) { "1개 이상의 로또 라인을 가지고 있어야 합니다." }
    }

    fun extractLottoGameResult(
        winningLottoLine: LottoLine,
        profitRateCalculator: ProfitRateCalculator,
    ): LottoGameResult {
        return LottoGameResult(
            lines.map { it.extractMatchCount(winningLottoLine) }
                .map { LottoRank.fromMatchCount(it) }
                .groupingBy { it }
                .eachCount(),
            profitRateCalculator,
        )
    }

    fun extractLottoLines(): List<List<Int>> {
        return lines.map { it.extractLottoNumbers().sorted() }
    }
}
