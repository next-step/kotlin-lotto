package lotto.domain

import java.lang.Exception

class LottoManualGenerateStrategy : LottoGenerateStrategy {
    override fun generate(): Set<LottoNumber> {
        throw Exception()
    }
}
