package study.lotto.domain

class Lottoes(private val list: List<Lotto>) : List<Lotto> by list {
    fun countMatches(winningLotto: Lotto) = list.map { it.countMatches(winningLotto) }

    companion object {
        fun buyLottoes(purchaseAmount: Int): Lottoes {
            require(purchaseAmount >= 0) {
                "purchaseAmount must be a positive value"
            }

            val lottoList = (1..(purchaseAmount / Lotto.PRICE_PER_TICKET)).map { Lotto.generate() }
            return Lottoes(lottoList)
        }
    }
}
