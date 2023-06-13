package lotto

import lotto.domain.Lottery
import lotto.domain.LottoNumber

fun mockLottery(vararg numbers: Int): Lottery = Lottery(
    numbers = numbers.map { LottoNumber(number = it) }
        .toSet(),
)

fun mockLottoNumbers(vararg numbers: Int): Set<LottoNumber> = numbers.map { LottoNumber(number = it) }
    .toSet()
