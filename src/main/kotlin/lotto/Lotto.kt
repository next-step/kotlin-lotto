package lotto

const val COUNT_OF_NUMBERS = 6
private const val MAX_NUMBER = 45
private const val MIN_NUMBER = 1

object Lotto {

    fun getNumbers(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled().subList(0, COUNT_OF_NUMBERS).sorted()
    }

    fun checkResult(lottoNumbers: List<Int>, prizeNumbers: List<Int>): Int {
        var count: Int = 0
        lottoNumbers.forEach { if (prizeNumbers.contains(it)) count++ }
        return count
    }
}
