package lotto.stretagy

import lotto.constant.MAXIMUM_NUMBER
import lotto.constant.MINIMUM_NUMBER
import lotto.constant.REQUIRED_LOTTO_SIZE
import lotto.domain.LottoNumber

class RandomLottoNumberListGenerator : LottoNumberListGenerator {
    override fun generate(): Set<LottoNumber> {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).shuffled()
            .take(REQUIRED_LOTTO_SIZE)
            .sorted()
            .map(::LottoNumber)
            .toSet()
    }
}
