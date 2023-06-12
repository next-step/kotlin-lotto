package lotto.domain.generator

import lotto.domain.LottoNumber

val RandomLottoNumbersGenerator = LottoNumbersGenerator {
    (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE).shuffled()
        .subList(0, 6)
        .sorted()
        .map(LottoNumber::valueOf)
}
