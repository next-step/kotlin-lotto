package lotto.domain

enum class WinnerType(val matchedNumbers: Int, val prizeMonery: Long, val desc: String? = null) {
    MATCHED_THREE_NUMBERS(3, 5_000),
    MATCHED_FOUR_NUMBERS(4, 50_000),
    MATCHED_FIVE_NUMBERS(5, 1_500_000),
    MATCHED_FIVE_NUMBERS_WITH_BONUS(5, 30_000_000, ", 보너스 볼 일치"),
    MATCHED_SIX_NUMBERS(6, 2_000_000_000);

    companion object {
        fun valueOf(matchedNumbers: Int, matchedBonus: Boolean): WinnerType? {
            require((0..Lotto.LOTTO_NUMBER_COUNT).contains(matchedNumbers)) {
                "matchedNumber는 0~${Lotto.LOTTO_NUMBER_COUNT}에 존재해야 합니다."
            }

            val winnerType = values().find { it.matchedNumbers == matchedNumbers }
            if (winnerType?.equals(MATCHED_FIVE_NUMBERS) == true && matchedBonus) {
                return MATCHED_FIVE_NUMBERS_WITH_BONUS
            }
            return winnerType
        }
    }

    override fun toString(): String {
        return "${matchedNumbers}개 일치${desc ?: ""} (${prizeMonery}원)"
    }
}
