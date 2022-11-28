package lotto.domain.lotto.benefit

enum class LottoBenefitLevel(
    val matchCount: Int,
    val benefitPerTicket: Int,
) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    fun description(): String = "${matchCount}개 일치 (${benefitPerTicket}원)"

    companion object {
        private fun of(matchCount: Int): LottoBenefitLevel? = when (matchCount) {
            3 -> THREE
            4 -> FOUR
            5 -> FIVE
            6 -> SIX
            else -> null
        }

        fun benefitPerTicketOf(matchCount: Int): Int = of(matchCount)?.benefitPerTicket ?: 0
    }
}
