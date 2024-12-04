package lotto.strategy

import lotto.stretagy.LottoNumberListGenerator

class WinningLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}

class FirstRankLottoLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 6)
    }
}

class ThirdRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 5, 7)
    }
}

class FourRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 4, 44, 45)
    }
}

class FifthRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(1, 2, 3, 43, 44, 45)
    }
}

class NoRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return listOf(45, 44, 43, 43, 42, 41)
    }
}
