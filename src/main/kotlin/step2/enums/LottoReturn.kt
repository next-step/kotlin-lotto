package step2.enums

enum class LottoReturn(
    val matchCount: Int,
    val returnPrice: Int,
) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000),
    NONE(0, 0);

    companion object {
        fun from(matchCount: Int): LottoReturn {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
