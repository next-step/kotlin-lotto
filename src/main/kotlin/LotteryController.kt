import service.LotteryService

class LotteryController {

    fun startLotteryService() {
        val order = LotteryService.createOrder()
        val lotteries = LotteryService.purchaseByOrder(order)
        val prizeCountMap = LotteryService.checkAndCountLotto(lotteries)
        LotteryService.reportResult(prizeCountMap, lotteries.size)
    }
}
