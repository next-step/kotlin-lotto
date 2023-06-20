package lotto.model

class LottoWinning(numbers: List<Int>) {

    private val winningNumbers = Lotto.createWinning(numbers)

    fun lottoResult(lottoList: List<Lotto>): Map<LottoPrize, Int> = lottoList.map {
        winningNumbers.matchingCount(it)
    }.mapNotNull {
        LottoPrize.of(it)
    }.groupingBy { it }.eachCount()
}
