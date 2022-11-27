package lotto.domain

class WinningLotto(private val numbers: Set<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun compareWith(lotto: Lotto): CompareResult {
        return when (numbers.intersect(lotto.numbers.toSet()).size) {
            6 -> CompareResult.FirstWin
            5 -> CompareResult.SecondWin
            4 -> CompareResult.ThirdWin
            3 -> CompareResult.FourthWin
            else -> CompareResult.NotWin
        }
    }
}
