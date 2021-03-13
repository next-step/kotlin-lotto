fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.buy(price)
    val lottoCards = LottoCards(lottoCnt)
    printLottoCards(lottoCards)

    val beforeWeekLottoCard = LottoCard(inputLottoNumber())
    val statistic = lotto.getStatistic(lottoCards, beforeWeekLottoCard)
    val yieldRate = lotto.getYieldRate(statistic, price)
    printResult(statistic, yieldRate)
}

class Lotto {
    fun getYieldRate(statistic: List<Winning>, price: Int): Double {
        return statistic.map { it.price }.sum().toDouble() / price
    }

    fun getStatistic(lottoCards: LottoCards, beforeWeekLottoCard: LottoCard): List<Winning> {
        return lottoCards.cards.mapNotNull {
            val count = it.getMatchCount(beforeWeekLottoCard)
            Winning.matchWinning(count)
        }
    }

    fun validatePrice(strPrice: String?): Int {
        require(!strPrice.isNullOrBlank()) { "구입금액을 반드시 입력해야합니다." }

        val price = parseInt(strPrice)
        require(price > 1000) { "구입 금액은 1000원보다 커야합니다." }

        return price
    }

    private fun parseInt(strNumber: String): Int {
        try {
            return strNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("자연수로 변환하는데 실패했습니다.")
        }
    }

    fun buy(price: Int): Int {
        return price / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
