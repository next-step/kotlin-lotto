package domain

enum class LottoWinningType(val priceMoney: Int, val matchingCount: Int?) {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, null),
    ;

    companion object {
        fun fromMatchCount(matchingCount: Int?): LottoWinningType {
            return entries.find { it.matchingCount == matchingCount } ?: NONE
        }
    }
}
