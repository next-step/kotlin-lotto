package lotto.domain

object LottoResultService {
    fun inquireResult(luckyNumbers: List<Int>, lottoList: List<Lotto>): List<LottoResult> {
        return lottoList.map { lotto ->
            val hitCount = countHitNumbers(lotto, luckyNumbers)
            LottoResult(lotto, hitCount, calculatePrizeMoney(hitCount))
        }
    }

    private fun countHitNumbers(lotto: Lotto, luckyNumbers: List<Int>) =
        lotto.numbers.count { number -> luckyNumbers.contains(number) }

    private fun calculatePrizeMoney(count: Int) = Lotto.PRIZE_MONEY_PER_HIT_COUNT.getOrDefault(count, 0)
}
