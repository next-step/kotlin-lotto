package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_COUNT) { "Lotto numbers should be $NUMBER_COUNT numbers." }
    }

    fun getMatchedNumberCount(winningNumbers: WinningNumbers): Int {
        return numbers.toSet()
            .intersect(winningNumbers.numbers.toSet())
            .count()
    }

    fun isBonusNumberMatch(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        val PRICE = Won(1000)
        const val NUMBER_COUNT = 6
    }
}
