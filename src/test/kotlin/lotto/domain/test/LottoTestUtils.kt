package lotto.domain.test

import lotto.domain.lottery.Lottery
import lotto.domain.lottery.LotteryNumber
import lotto.domain.lottery.LotteryTicket

fun lotteryNumbers(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int): Set<LotteryNumber> =
    setOf(LotteryNumber(n1), LotteryNumber(n2), LotteryNumber(n3), LotteryNumber(n4), LotteryNumber(n5), LotteryNumber(n6))
fun lottery(n1: Int, n2: Int, n3: Int, n4: Int, n5: Int, n6: Int) =
    Lottery(setOf(LotteryNumber(n1), LotteryNumber(n2), LotteryNumber(n3), LotteryNumber(n4), LotteryNumber(n5), LotteryNumber(n6)))
fun lotteryTicket(vararg lotto: Lottery): LotteryTicket =
    LotteryTicket(listOf(*lotto))
