package lotto.domain

class Lotto(
    private val numList: List<LottoNumber>
) {

    init {
        isValid(numList)
    }

    override fun toString(): String {
        return numList.sorted().toString()
    }

    fun numOfMatch(winningNums: List<LottoNumber>): Int {
        return winningNums.intersect(numList.toSet()).count()
    }

    private fun isValid(numList: List<LottoNumber>) {
        require(numList.toSet().size == COUNT_OF_LOTTO_NUMBER)
    }

    companion object {
        const val PRICE = 1000
        const val COUNT_OF_LOTTO_NUMBER = 6
    }
}
