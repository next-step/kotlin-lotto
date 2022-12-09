package lotto.domain.lotto.benefit

import lotto.domain.lotto.result.LottoTicketResult
import java.util.EnumSet

enum class LottoBenefitLevel(
    val matchCount: Int,
    val benefitPerTicket: Int,
    val isBonus: Boolean = false
) {
    INVALID(-1, 0),
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000);

    fun isPositiveBenefitLevel(): Boolean = positiveBenefitLevelSet().contains(this)

    fun description(): String = "${matchCount}개 일치${if (isBonus) ", 보너스 볼 일치" else " "}(${benefitPerTicket}원)"

    companion object {

        fun of(lottoTicketResult: LottoTicketResult): LottoBenefitLevel =
            of(lottoTicketResult.matchCount, lottoTicketResult.isBonus)

        fun benefitPerTicketOf(lottoTicketResult: LottoTicketResult): Int =
            of(lottoTicketResult).benefitPerTicket

        fun positiveBenefitLevelSet(): EnumSet<LottoBenefitLevel> = EnumSet.of(
            THREE,
            FOUR,
            FIVE,
            FIVE_WITH_BONUS,
            SIX
        )

        fun validBenefitLevelSet(): EnumSet<LottoBenefitLevel> = EnumSet.of(
            ZERO,
            ONE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            FIVE_WITH_BONUS,
            SIX
        )

        private fun of(matchCount: Int, isBonus: Boolean = false): LottoBenefitLevel =
            values().find { it.matchCount == matchCount && it.isBonus == isBonus } ?: INVALID
    }
}
