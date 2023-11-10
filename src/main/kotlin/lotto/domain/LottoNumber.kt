package lotto.domain

data class LottoNumber(
    val line: List<Int>
) {
    fun getSameNumberCount(numbers: List<Int>) = line.count { numbers.contains(it) }
    fun isContainsBonusNumber(bonusNumber: Int) = line.contains(bonusNumber)
}
