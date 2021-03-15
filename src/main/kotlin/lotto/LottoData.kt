package lotto

class LottoData(val numbers: List<Int>) {

    var matchNumbers: List<Int> = mutableListOf()
        private set

    var hasMatchBonusNumber: Boolean = false
        private set

    fun match(winNumber: List<Int>, bonusNumber: Int): Boolean {
        matchNumbers = numbers.filter { number -> winNumber.contains(number) }
        hasMatchBonusNumber = numbers.contains(bonusNumber)
        return isWinnerLotto()
    }

    fun isWinnerLotto(): Boolean {
        return matchNumbers.isNotEmpty()
    }

    fun getMatchedNumberCount(): Int {
        return matchNumbers.size
    }
}
