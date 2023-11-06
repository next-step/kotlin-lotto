package lotto.domain

class LottoNumber(
    private val line: List<Int>
) {
    val size = line.size
    fun getSameNumberCount(numbers: List<Int>) = line.count { numbers.contains(it) }
}
