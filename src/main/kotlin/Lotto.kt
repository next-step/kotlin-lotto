
fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.canBuyCount(price)
    val lottoCards = LottoCards(lottoCnt)
    printLottoCards(lottoCards)

    val numbers = lotto.parseNumbers(inputLottoNumber())
    val beforeWeekLottoCard = LottoCard(numbers)
    val bonusNumber = lotto.validateBonusNumber(inputBonusNumber())
    val statistic = lottoCards.getStatistic(beforeWeekLottoCard, bonusNumber)
    val yieldRate = lotto.getYieldRate(statistic, price)
    printResult(statistic, yieldRate)
}

class Lotto {
    fun getYieldRate(statistic: Map<Winning, Int>, price: Int): Double {
        return statistic.map { it.key.price * it.value }.sum().toDouble() / price
    }

    fun validateBonusNumber(numberLine: String?): Int {
        require(!numberLine.isNullOrBlank()) { "보너스 번호를 반드시 입력해야 합니다." }

        return numberLine.parseInt()
    }

    fun parseNumbers(numberLine: String?): List<Int> {
        require(!numberLine.isNullOrBlank()) { "로또 번호를 반드시 입력해야 합니다." }
        return numberLine.replace(WHITESPACE_REGEX, EMPTY_STRING).split(",").map { it.parseInt() }
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
