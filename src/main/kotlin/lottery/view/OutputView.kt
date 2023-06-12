package lottery.view

private const val LOTTERY_NUMBER_DELIMITER = ", "

fun printPurchaseLotteries(lotteries: List<List<Int>>) {
    println("${lotteries.size}를 구매했습니다.")
    lotteries.forEach { printLottery(it) }
}

private fun printLottery(lottery: List<Int>) {
    println("[${lottery.map { it }.joinToString(LOTTERY_NUMBER_DELIMITER)}]")
}
