package lotto.number

data class Numbers(
    val numbers: List<Int>,
) {
    fun hasNumber(number: Int): Boolean = numbers.contains(number)

    fun countMatching(other: Numbers): Int = other.numbers.count { this.hasNumber(it) }
}
