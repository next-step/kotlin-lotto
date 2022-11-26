package lotto.domain

data class AwardResult(
    val award: Award,
    val matchCount: Int
) {

    val sumOfPrize
        get() = award.prize * matchCount

    init {
        require(matchCount >= 0) { "사용자 수는 양수만 올 수 있어요" }
    }
}
