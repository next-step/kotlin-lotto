package lotto.strategy

import lotto.stretagy.LottoNumberListGenerator

class FourRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 44, 45)
    }
}
