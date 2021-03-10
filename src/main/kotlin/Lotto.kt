
fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.buy(price)
    val lottoCards = lotto.extractNumber(lottoCnt)
    printLottoCards(lottoCards)

    val beforeWeekLottoCard = lotto.validateLottoCard(inputLottoNumber())
    val statistic = lotto.getStatistic(lottoCards, beforeWeekLottoCard)
    val yieldRate = lotto.getYieldRate(statistic, price)
    printResult(statistic, yieldRate)
}

class Lotto {
    fun getYieldRate(statistic: List<Winning>, price: Int): Double {
        return statistic.map { it.price }.sum().toDouble() / price
    }

    fun getStatistic(lottoCards: List<LottoCard>, beforeWeekLottoCard: LottoCard): List<Winning> {
        return lottoCards.mapNotNull {
            val count = getMatchCount(it, beforeWeekLottoCard)
            Winning.matchWinning(count)
        }
    }

    private fun getMatchCount(lottoCard: LottoCard, winningLottoCard: LottoCard): Int {
        return lottoCard.number.filter { winningLottoCard.number.contains(it) }.size
    }

    fun validateLottoCard(lottoNumber: String?): LottoCard {
        require(!lottoNumber.isNullOrBlank()) { "로또 번호를 반드시 입력해야 합니다." }

        val strNumbers = lottoNumber.trim().split(",")
        require(strNumbers.size == LOTTO_NUMBER_CNT) { "로또 번호는 6개입니다." }

        val numbers = strNumbers.map { parseInt(it) }
        require(numbers.none { it < LOTTO_START_NUMBER || it > LOTTO_LAST_NUMBER }) { "입력된 숫자가 로또 번호의 범위 밖입니다." }

        return LottoCard(numbers)
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

    fun extractNumber(cnt: Int): List<LottoCard> {
        return (1..cnt).map {
            LottoCard(LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_CNT))
        }
    }

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_CNT = 6
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        val LOTTO_NUMBERS = (LOTTO_START_NUMBER..LOTTO_LAST_NUMBER).toList()
    }
}
