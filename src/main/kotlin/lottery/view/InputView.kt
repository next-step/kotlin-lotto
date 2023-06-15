package lottery.view

import java.math.BigDecimal

fun inputPurchaseMoney(): BigDecimal {
    println("구입금액을 입력해 주세요.")
    return readln().toBigDecimalOrNull() ?: retryInputPurchaseMoney()
}

fun inputWinningLottery(): List<String> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readln().split(",")
}

private fun retryInputPurchaseMoney(): BigDecimal {
    println("구입금액은 숫자를 입력하여야 합니다.")
    return inputPurchaseMoney()
}
