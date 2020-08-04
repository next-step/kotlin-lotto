package lotto.domain

class Lotto(candidateNumbers: List<String>) {
    val numbers = sortList(makeList(candidateNumbers))

    private fun sortList(list: List<Number>): List<Number> = list.sortedBy { it.number }

    private fun makeList(candidateNumbers: List<String>): List<Number> = candidateNumbers.take(6).map { Number(it) }

    fun getRank(numbers: List<Number>): Int = numbers.filter { isCorrect(it) }.size

    private fun isCorrect(number: Number): Boolean = numbers.contains(number)
}
