package lotto

enum class Prize(
    val matchCount: Int,
    val prizeAmount: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000), ;

    companion object {
        fun findByMatchCount(matchCount: Int): Prize {
            return entries.find { it.matchCount == matchCount }
                ?: throw RuntimeException("일치하는 숫자의 개수에 해당하는 상품이 존재하지 않습니다.")
        }
    }
}
