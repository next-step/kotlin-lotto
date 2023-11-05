package lotto.domain

class Lotto(
    val lines: List<List<Int>>
) {
    fun getAllSameNumberCount(numbers: List<Int>): List<Int> =
        lines.map { it.getSameNumberCount(numbers) }.toList()

    private fun List<Int>.getSameNumberCount(numbers: List<Int>) =
        this.count { numbers.contains(it) }
}
