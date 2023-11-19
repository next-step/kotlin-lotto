package lotto.domain

enum class LottoResult(val countOfMatch: Int, val price: Int) {
    MATCH_6_NUMBERS(6, 2_000_000_000),
    MATCH_5_NUMBERS(5, 1_500_000),
    MATCH_4_NUMBERS(4, 50_000),
    MATCH_3_NUMBERS(3, 5_000),
    NONE(0, 0)
    ;

    companion object {
        fun of(countOfMatch: Int): LottoResult {
            require(countOfMatch in 0..6) { "유효하지 않은 숫자입니다" }
            return values().find { it.countOfMatch == countOfMatch } ?: NONE
        }
    }
}