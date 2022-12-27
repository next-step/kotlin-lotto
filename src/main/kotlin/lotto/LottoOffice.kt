package lotto

object LottoOffice {
    const val ONE_LOTTO_PRICE = 1000
    fun buyTickets(buyPrice: BuyPrice) = buyPrice.price.div(ONE_LOTTO_PRICE)

    fun getRank(winnerNumbers: LottoNumbers, boughtLottos: List<LottoNumbers>): List<Rank> {
        return boughtLottos.map { boughtLotto ->
            Rank.of(boughtLotto.count { winnerNumbers.contains(it) })
        }
    }
}
