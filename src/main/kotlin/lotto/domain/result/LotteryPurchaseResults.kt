package lotto.domain.result

class LotteryPurchaseResults(private val results: List<LotteryPurchaseResult>) {
    fun getLotteryTicket() =
        results.map { it.lotteryTicket }.reduce { acc, lotteryTicket -> acc merge lotteryTicket }

    fun seperatedByPurchaseType() = results.associateBy { it.type }
}
