package step2Lotto.domain.dto

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2000000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOSE(0)
}
