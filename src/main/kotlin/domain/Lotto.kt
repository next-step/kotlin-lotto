package domain

interface Lotto {
    val numbers: List<Int>
    val winningCount: Int?
}

class PurchasedLotto(override val numbers: List<Int>, override val winningCount: Int = 0) : Lotto {
    fun calculateWinningCount(winningLotto: WinningLotto): Int{
        return winningLotto.numbers.filter {
            this.numbers.contains(it)
        }.size
    }
}

class WinningLotto(override val numbers: List<Int>, override val winningCount: Int? = null) : Lotto