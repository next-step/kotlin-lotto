package lotto.model

class LottoWinning(numbers: Set<Int>, bonus: Int) {

    private val winningNumbers = Lotto.create(numbers)
    private val bonusNumber = LottoNumber(bonus)

    init {
        require(winningNumbers.isBonus(bonusNumber).not()) {
            "당첨 번호 안에 보너스 번호가 포함되어 있습니다."
        }
    }

    fun lottoResult(lottoList: List<Lotto>): Map<Rank, Int> = lottoList.map {
        it.matchingCount(winningNumbers) to it.isBonus(bonusNumber)
    }.mapNotNull {
        Rank.of(it.first, it.second)
    }.groupingBy { it }.eachCount()
}
