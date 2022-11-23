package lotto.domain

object LottoMatcher {

    fun matchingCount(numbers: List<Int>, list: List<Int>): Int {
        var count = 0
        numbers.forEach { number ->
            count += checkMatchingNumber(number, list)
        }
        return count
    }

    private fun checkMatchingNumber(number: Int, list: List<Int>): Int {
        return if (list.contains(number)) 1 else 0
    }
}
