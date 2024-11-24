package lotto.domain

class LottoLines(private val lines: List<LottoLine>) {
    init {
        require(lines.isNotEmpty()) { "1개 이상의 로또 라인을 가지고 있어야 합니다." }
    }

    fun extractLottoGameResult(
        winningLotto: WinningLotto,
        profitRateCalculator: ProfitRateCalculator,
    ): LottoGameResult {
        val lottoRanks =
            lines.map {
                val (matchCount, bonusMatch) = winningLotto.match(it)
                LottoRank.fromMatchAndBonus(matchCount, bonusMatch)
            }.groupingBy { it }.eachCount()

        return LottoGameResult(lottoRanks, profitRateCalculator)
    }

    fun extractLottoLines(): List<List<Int>> {
        return lines.map { it.extractLottoNumbers().sorted() }
    }
}
