package lotto.enums

import lotto.constant.FIFTH_RANK_NUMBER
import lotto.constant.FIFTH_RANK_PRIZE
import lotto.constant.FIRST_RANK_NUMBER
import lotto.constant.FIRST_RANK_PRIZE
import lotto.constant.FOURTH_RANK_NUMBER
import lotto.constant.FOURTH_RANK_PRIZE
import lotto.constant.NO_PRIZE
import lotto.constant.NO_RANK_NUMBER
import lotto.constant.THIRD_RANK_NUMBER
import lotto.constant.THIRD_RANK_PRIZE

enum class LottoRank(val rank: Int, val prize: Int) {
    FIRST_RANK(FIRST_RANK_NUMBER, FIRST_RANK_PRIZE),
    THIRD_RANK(THIRD_RANK_NUMBER, THIRD_RANK_PRIZE),
    FOURTH_RANK(FOURTH_RANK_NUMBER, FOURTH_RANK_PRIZE),
    FIFTH_RANK(FIFTH_RANK_NUMBER, FIFTH_RANK_PRIZE),
    NO_RANK(NO_RANK_NUMBER, NO_PRIZE),
    ;

    companion object {
        fun of(rank: Int): LottoRank {
            return when (rank) {
                FIRST_RANK_NUMBER -> FIRST_RANK
                THIRD_RANK_NUMBER -> THIRD_RANK
                FOURTH_RANK_NUMBER -> FOURTH_RANK
                FIFTH_RANK_NUMBER -> FIFTH_RANK
                else -> NO_RANK
            }
        }
    }
}
