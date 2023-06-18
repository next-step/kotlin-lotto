package lotto.domain

class LottoReturnCalculator(private val lottoList: List<LottoNumbers>) {
    fun calculate(winningNumbers: LottoNumbers): LottoReturn {
        return lottoList.map {
            winningNumbers.numberOfOverlaps(it)
        }
            .groupingBy { it }
            .eachCount()
            .toLottoResults()
    }

    private fun Map<Int, Int>.toLottoResults(): LottoReturn {
        return LottoReturn(
            firstCount = getOrDefault(LottoNumbers.LENGTH, 0),
            secondCount = getOrDefault(LottoNumbers.LENGTH - 1, 0),
            thirdCount = getOrDefault(LottoNumbers.LENGTH - 2, 0),
            fourthCount = getOrDefault(LottoNumbers.LENGTH - 3, 0),
            paidAmount = paidAmount
        )
    }

    private val paidAmount: Int = lottoList.size * LottoVendingMachine.LOTTO_PRICE
}
