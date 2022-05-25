package lotto

data class PrizeDto(val matchCount: Int, private val Prize: List<Int>) {
    val price = Prize[0]
    val numberOfCorrect = Prize[1]
}
