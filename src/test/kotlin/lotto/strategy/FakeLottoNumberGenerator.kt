package lotto.strategy

import lotto.domain.LottoNumber
import lotto.stretagy.LottoNumberListGenerator

class WinningLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).toSet()
    }
}

class FirstRankLottoLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).toSet()
    }
}

class ThirdRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber).toSet()
    }
}

class FourRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(1, 2, 3, 4, 44, 45).map(::LottoNumber).toSet()
    }
}

class FifthRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(1, 2, 3, 43, 44, 45).map(::LottoNumber).toSet()
    }
}

class NoRankLottoNumberGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return listOf(45, 44, 43, 42, 41, 40).map(::LottoNumber).toSet()
    }
}
