package lotto.domain

class Lotto(
    val lines: List<LottoNumber>
) {
    fun getAllSameNumberCount(numbers: List<Int>): List<Int> =
        lines.map { it.getSameNumberCount(numbers) }.toList()

}
