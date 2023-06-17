package lottery.view

import java.math.BigDecimal

fun inputPurchaseMoney(): BigDecimal {
    println("구입금액을 입력해 주세요.")
    return readln().toBigDecimalOrNull() ?: retryInputPurchaseMoney()
}

fun inputPurchaseManualLottery(): List<List<String>> {
    val purchaseCount = inputPurchaseManualLotteryCount()
    println("수동으로 구매할 번호를 입력해 주세요.")
    return (1..purchaseCount).map { inputPurchaseManualLotteryNumber() }
}

fun inputWinningLottery(): List<String> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readln().split(",")
}

fun inputBonusLotteryNumber(): Int {
    println("보너스 볼을 입력해 주세요.")
    return readln().toIntOrNull() ?: retryInputBonusLotteryNumber()
}

private fun retryInputPurchaseMoney(): BigDecimal {
    println("구입금액은 숫자를 입력하여야 합니다.")
    return inputPurchaseMoney()
}

private fun inputPurchaseManualLotteryCount(): Int {
    println("수동으로 구매할 로또 수를 입력해 주세요.")
    return readln().toIntOrNull() ?: retryInputPurchaseManualLotteryCount()
}

private fun retryInputPurchaseManualLotteryCount(): Int {
    println("로또 수는 숫자를 입력하여야 합니다.")
    return inputPurchaseManualLotteryCount()
}

private fun inputPurchaseManualLotteryNumber(): List<String> {
    return readln().split(",")
}

private fun retryInputBonusLotteryNumber(): Int {
    println("보너스 번호는 숫자를 입력하여야 합니다.")
    return inputBonusLotteryNumber()
}
