package lotto.strategy

import lotto.stretagy.LottoNumberListGenerator

class FifthRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 43, 44, 45)
    }
}
