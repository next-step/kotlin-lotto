package lotto.dto

import lotto.domain.LotterySet

data class BuyLotteriesDTO(val autoLotteries: LotterySet, val manualLotteries: LotterySet) {

    fun printLotteries(): String {
        return listOf(autoLotteries, manualLotteries).flatten().joinToString("\n", postfix = "\n")
    }

    fun printStatistics(): String {
        return "수동 ${manualLotteries.size}개, 자동 ${autoLotteries.size}개를 구매했습니다.\n"
    }
}
