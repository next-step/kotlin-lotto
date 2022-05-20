package lotto.domain

import lotto.vo.Money

enum class LottoRank(
    val matchCount: Int,
    val winningAmount: Money
) {
    FIRST(6, Money.of(2_000_000_000)),
    SECOND(5, Money.of(1_500_000)),
    THIRD(4, Money.of(50_000)),
    FOURTH(3, Money.of(5_000)),
    NOTTING(2, Money.of(0));

    companion object {
        fun of(matchCount: Int): LottoRank {
            require(matchCountRange(matchCount)) {
                "당첨 결과는 0~6 까지 허용합니다 (입력:$matchCount)"
            }

            return LottoRank.values()
                .find { it.matchCount == matchCount }
                ?: NOTTING
        }

        private fun matchCountRange(matchCount: Int) = matchCount in 0..6
    }
}
