package study.lotto.domain

object LottoShop {
    fun buyLottoes(purchaseAmount: Amount, manualBuying: Lottoes = Lottoes(emptyList())): BuyingLottoes {
        val buyLottoesCount = purchaseAmount / Lotto.PRICE_PER_TICKET
        val lottoList = List(buyLottoesCount - manualBuying.size) { Lotto.generate() }
        return BuyingLottoes(Lottoes(lottoList), manualBuying)
    }
}
