package lotto.domain

data class Lotto(val numbers: List<Int>) {

    fun getMatchCount(luckyNumbers: List<Int>): Int {
        return luckyNumbers.filter { numbers.contains(it) }.size
    }

    override fun toString(): String {
        return "$numbers"
    }
}
