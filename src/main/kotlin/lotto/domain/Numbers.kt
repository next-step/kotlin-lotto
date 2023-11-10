package lotto.domain

data class Numbers(
    private val numbers: List<Int> = listOf()
) {
    val randomNumbers = numbers
}
