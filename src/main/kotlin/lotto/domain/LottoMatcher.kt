package lotto.domain

object LottoMatcher {

    fun match(numbers: List<Int>, list: List<Int>): Int {
        var count = 0
        numbers.forEach { number ->
            count += checkNumber(number, list)
        }
        return count
    }

    private fun checkNumber(number: Int, list: List<Int>): Int {
        return if (list.contains(number)) 1 else 0
    }
}
