package lotto

class Lotto(
    private val numList: List<Int>
) {

    override fun toString(): String {
        return numList.sorted().toString()
    }

    fun numOfMatch(winningNums: List<Int>): Int {
        return winningNums.intersect(numList.toSet()).count()
    }

    companion object {
        const val PRICE = 1000
    }
}