package lotto.view

import lotto.domain.Lotteries
import lotto.domain.Money
import lotto.domain.Numbers

object InputView {
    fun askMoney(): Money {
        println("구입금액을 입력해 주세요.")
        val input = readln().toLongOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.")
        return Money(input)
    }

    fun print(lotteries: Lotteries) {
        println("${lotteries.size()}개를 구매했습니다.")
        lotteries.lotteries.forEach { println(it.numbers) }
        println()
    }

    fun askWinningNumbers(): Numbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(",").map { it.trim().toInt() }
        return Numbers(numbers)
    }
}
