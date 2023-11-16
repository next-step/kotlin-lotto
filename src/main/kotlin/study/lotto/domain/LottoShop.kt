package study.lotto.domain

object LottoShop {
    fun buyLottoes(purchaseAmount: Amount): Lottoes {
        val buyLottoesCount = purchaseAmount / Lotto.PRICE_PER_TICKET
        val lottoList = List(buyLottoesCount) { Lotto.generate() }
        return Lottoes(lottoList)
    }
}
