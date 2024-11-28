package lotto.domain

import lotto.enums.RankType
import lotto.enums.RankType.FIFTH_RANK
import lotto.enums.RankType.FIRST_RANK
import lotto.enums.RankType.FOURTH_RANK
import lotto.enums.RankType.NO_RANK
import lotto.enums.RankType.THIRD_RANK

class Statistics {
    companion object {
        fun lottoRank(
            userLottos: List<Lotto>,
            winningLotto: Lotto,
        ): Map<RankType, Int> {
            val lottoResult: MutableMap<RankType, Int> =
                mutableMapOf(NO_RANK to 0, FIRST_RANK to 0, THIRD_RANK to 0, FOURTH_RANK to 0, FIFTH_RANK to 0)

            userLottos.forEach {
                val rank = Match.lottoNumber(it, winningLotto)
                val rankType = RankType.of(rank)
                lottoResult[rankType] = (lottoResult[rankType] ?: 0) + 1
            }

            return lottoResult.toMap()
        }
    }
}
