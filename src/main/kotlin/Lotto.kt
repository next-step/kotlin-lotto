import LottoCard.Companion.LOTTO_LAST_NUMBER
import LottoCard.Companion.LOTTO_NUMBER_CNT
import LottoCard.Companion.LOTTO_START_NUMBER

fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.canBuyCount(price)
    val lottoCards = LottoCards(lottoCnt)
    printLottoCards(lottoCards)

    val numbers = lotto.validateLottoCard(inputLottoNumber())
    val beforeWeekLottoCard = LottoCard(numbers)
    val statistic = lotto.getStatistic(lottoCards, beforeWeekLottoCard)
    val yieldRate = lotto.getYieldRate(statistic, price)
    printResult(statistic, yieldRate)
}

class Lotto {
    fun getYieldRate(statistic: List<Winning>, price: Int): Double {
        return statistic.map { it.price }.sum().toDouble() / price
    }

    fun getStatistic(lottoCards: LottoCards, beforeWeekLottoCard: LottoCard): List<Winning> {
        return lottoCards.cards.map {
            val count = it.getMatchCount(beforeWeekLottoCard)
            Winning.matchWinning(count)
        }
    }

    fun validateLottoCard(numberLine: String?): List<Int> {
        require(!numberLine.isNullOrBlank()) { "로또 번호를 반드시 입력해야 합니다." }

        val strNumbers = numberLine.replace(WHITESPACE_REGEX, EMPTY_STRING).split(",")
        require(strNumbers.size == LOTTO_NUMBER_CNT) { "로또 번호는 6개입니다." }

        val numbers = strNumbers.map { it.parseInt() }
        require(numbers.none { it < LOTTO_START_NUMBER || it > LOTTO_LAST_NUMBER }) { "입력된 숫자가 로또 번호의 범위 밖입니다." }

        return numbers
    }

    fun validatePrice(strPrice: String?): Int {
        require(!strPrice.isNullOrBlank()) { "구입금액을 반드시 입력해야합니다." }

        val price = strPrice.parseInt()
        require(price > 1000) { "구입 금액은 1000원보다 커야합니다." }

        return price
    }

    fun canBuyCount(price: Int): Int {
        return price / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private val WHITESPACE_REGEX = Regex("\\s")
        private const val EMPTY_STRING = ""
    }
}
