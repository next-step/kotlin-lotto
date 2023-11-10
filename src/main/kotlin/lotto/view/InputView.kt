package lotto.view

import lotto.Lotto

private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
private const val INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
private const val INPUT_WINNING_NUMBERS_DELIMITER = ", "
private const val CONFIRM_COUNT_MESSAGE = "개를 구매했습니다."


fun readPrice(): Int {
    println(INPUT_PRICE_MESSAGE)
    return readln().toInt()
}

fun readWinningNumbers(): Set<Int> {
    println(INPUT_WINNING_NUMBERS_MESSAGE)
    return readln().split(INPUT_WINNING_NUMBERS_DELIMITER).map { it.toInt() }.toSet()
}

fun confirmCount(price: Int): Int {
    val count = price / Lotto.LOTTO_PRICE
    println("$count" + CONFIRM_COUNT_MESSAGE)
    return count
}
