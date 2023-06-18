package lotto.domain

class LottoReturnCalculator(private val lottoList: List<LottoNumbers>) {
    fun calculate(winningNumbers: LottoWinningNumbers): LottoReturn {
        return lottoList.map {
            winningNumbers.numberOfOverlaps(it)
        }
            .groupingBy { it }
            .eachCount()
            .toLottoResults(winningNumbers)
    }

    private fun Map<Int, Int>.toLottoResults(winningNumbers: LottoWinningNumbers): LottoReturn {
        val secondCount = lottoList.filter {
            winningNumbers.isSecondPlace(it)
        }.size

        return LottoReturn(
            firstCount = getOrDefault(Rank.FIRST.countOfMatch, 0),
            secondCount = secondCount,
            thirdCount = getOrDefault(Rank.THIRD.countOfMatch, 0) - secondCount,
            fourthCount = getOrDefault(Rank.FOURTH.countOfMatch, 0),
            fifthCount = getOrDefault(Rank.FIFTH.countOfMatch, 0),
            paidAmount = paidAmount
        )
    }

    private val paidAmount: Int = lottoList.size * LottoVendingMachine.LOTTO_PRICE
}
