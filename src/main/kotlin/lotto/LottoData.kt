package lotto

class LottoData(val numbers: List<Int>) {

    var matchNumbers: List<Int> = mutableListOf()
        private set

    fun match(winNumber: List<Int>): Boolean {
        matchNumbers = numbers.filter { number -> winNumber.contains(number) }
        return isWinnerLotto()
    }

    fun isWinnerLotto(): Boolean {
        return matchNumbers.isNotEmpty()
    }

    fun getMatchedNumberCount(): Int {
        return matchNumbers.size
    }
}
