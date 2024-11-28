package lotto.strategy

import lotto.stretagy.LottoNumberListGenerator

class NoRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(45, 44, 43, 43, 42, 41)
    }
}
