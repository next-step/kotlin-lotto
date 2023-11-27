package study.lotto.domain

object LottoShop {
    fun buyLottoes(
        purchaseAmount: Amount,
        markedLottoNumbersList: List<LottoNumbers> = emptyList(),
    ): BuyingLottoes {
        val buyingLottoesAmount = BuyingLottoesAmount(purchaseAmount)
        val lottoList = buyAutoLottoes(buyingLottoesAmount.amount - markedLottoNumbersList.size)

        return BuyingLottoes(BuyingAutoLottoes(Lottoes(lottoList)), buyManualLottoes(markedLottoNumbersList))
    }

    private fun buyAutoLottoes(
        buyingAutoLottoesSize: Int,
    ) = List(buyingAutoLottoesSize) { Lotto.generate() }

    private fun buyManualLottoes(markedLottoNumbersList: List<LottoNumbers>): BuyingManualLottoes {
        return markedLottoNumbersList
            .map(::Lotto)
            .let(::Lottoes)
            .let(::BuyingManualLottoes)
    }
}
