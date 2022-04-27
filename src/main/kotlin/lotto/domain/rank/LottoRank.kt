package lotto.domain.rank

import lotto.domain.matching.LottoMatching
import lotto.domain.matching.LottoMatching.FIRST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.FOURTH_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.LAST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.SECOND_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.THIRD_PLACE_MATCHING

enum class LottoRank(val lottoMatching: LottoMatching, val prize: Int) {
    FIRST_PLACE(FIRST_PLACE_MATCHING, 2_000_000_000),
    SECOND_PLACE(SECOND_PLACE_MATCHING, 1_500_000),
    THIRD_PLACE(THIRD_PLACE_MATCHING, 50_000),
    FOURTH_PLACE(FOURTH_PLACE_MATCHING, 5_000),
    LAST_PLACE(LAST_PLACE_MATCHING, 0);

    companion object {
        fun from(lottoMatching: LottoMatching): LottoRank {
            return values().first { it.lottoMatching == lottoMatching }
        }
    }
}
