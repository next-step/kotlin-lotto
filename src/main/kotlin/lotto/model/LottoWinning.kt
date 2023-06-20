package lotto.model

class LottoWinning(numbers: List<Int>, bonus: Int) {

    private val winningNumbers = Lotto.createWinning(numbers)
    private val bonusNumber = LottoNumber(bonus)

    fun lottoResult(lottoList: List<Lotto>): Map<Rank, Int> = lottoList.map {
        it.matchingCount(winningNumbers) to it.isBonus(bonusNumber)
    }.mapNotNull {
        Rank.of(it.first, it.second)
    }.groupingBy { it }.eachCount()
}
