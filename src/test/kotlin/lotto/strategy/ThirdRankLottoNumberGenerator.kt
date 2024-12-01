package lotto.strategy

import lotto.stretagy.LottoNumberListGenerator

class ThirdRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 7)
    }
}
