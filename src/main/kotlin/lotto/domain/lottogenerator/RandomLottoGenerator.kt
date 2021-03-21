package lotto.domain.lottogenerator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

object RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val lottoNumbers = LottoNumber.RANGE.toList()
            .shuffled()
            .take(Lotto.SIZE)
            .map { LottoNumber.of(it) }
            .toSortedSet()
        return Lotto(lottoNumbers)
    }
}
