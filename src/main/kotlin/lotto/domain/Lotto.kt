package lotto.domain

data class Lotto(
    val numbers: List<Int>
) {
    fun getMatchCount(otherLotto: Lotto): Int {
        var count = 0
        otherLotto.numbers.forEach { number ->
            if (numbers.contains(number)) count++
        }
        return count
    }
}
