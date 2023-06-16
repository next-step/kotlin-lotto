package lotto

import lotto.domain.Lottery
import lotto.domain.LottoNumber
import lotto.domain.WinningLottery

fun mockLottery(vararg numbers: Int): Lottery = Lottery(
    numbers = numbers.map { LottoNumber(number = it) }
        .toSet(),
)

fun mockWinningLottery(bonusBall: LottoNumber, vararg numbers: Int): WinningLottery = WinningLottery(
    numbers = numbers.map { LottoNumber(number = it) }
        .toSet(),

    bonusBall = bonusBall,
)

fun mockLottoNumbers(vararg numbers: Int): Set<LottoNumber> = numbers.map { LottoNumber(number = it) }
    .toSet()
