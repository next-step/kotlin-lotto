package lottery.view

import java.math.BigDecimal

private const val LOTTERY_NUMBER_DELIMITER = ","

fun inputPurchaseMoney(): BigDecimal {
    println("구입금액을 입력해 주세요.")
    return readln().toBigDecimalOrNull() ?: retryInputPurchaseMoney()
}

fun inputPurchaseManualLottery(): List<List<String>> {
    val purchaseCount = inputPurchaseManualLotteryCount()
    printPurchaseCountRequest(purchaseCount)
    return (1..purchaseCount).map { inputPurchaseManualLotteryNumber() }
}

fun inputWinningLottery(): List<String> {
    println("지난 주 당첨 번호를 입력해 주세요.")
    return readln().split(LOTTERY_NUMBER_DELIMITER)
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
    val count = readln().toIntOrNull() ?: retryInputPurchaseManualLotteryCount()
    if (count < 0) {
        return retryInputPurchaseManualLotteryCount()
    }
    return count
}

private fun retryInputPurchaseManualLotteryCount(): Int {
    println("로또 수는 0이상의 숫자를 입력하여야 합니다.")
    return inputPurchaseManualLotteryCount()
}

private fun printPurchaseCountRequest(purchaseCount: Int) {
    if (purchaseCount > 0) {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }
}

private fun inputPurchaseManualLotteryNumber(): List<String> {
    return readln().replace(" ", "")
        .split(LOTTERY_NUMBER_DELIMITER)
}

private fun retryInputBonusLotteryNumber(): Int {
    println("보너스 번호는 숫자를 입력하여야 합니다.")
    return inputBonusLotteryNumber()
}
