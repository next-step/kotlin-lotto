
fun main() {
    val lotto = Lotto()
    val price = lotto.validatePrice(inputPrice())
    val lottoCnt = lotto.canBuyCount(price)
    val passiveCnt = lotto.validatePassiveCnt(inputPassive(), lottoCnt)

    val lottoCards = LottoCards()
    inputPassiveNumbers(passiveCnt, lotto).forEach { lottoCards.addLottoCard(it) }
    lottoCards.generateRandomLottoCard(lottoCnt - passiveCnt)
    printLottoCards(lottoCards)

    val beforeWeekLottoCard = lotto.parseLottoCard(inputLottoNumber())
    val bonusNumber = lotto.getBonusNumber(inputBonusNumber())
    val statistic = lottoCards.getStatistic(beforeWeekLottoCard, bonusNumber)
    val yieldRate = lotto.getYieldRate(statistic, price)
    printResult(statistic, yieldRate)
}

class Lotto {

    fun getYieldRate(statistic: Map<Winning, Int>, price: Int): Double {
        return statistic.map { it.key.price * it.value }.sum().toDouble() / price
    }

    fun getBonusNumber(numberLine: String?): LottoNumber {
        require(!numberLine.isNullOrBlank()) { "보너스 번호를 반드시 입력해야 합니다." }

        return LottoNumber(numberLine.parseInt())
    }

    fun parseLottoCard(numberLine: String?): LottoCard {
        require(!numberLine.isNullOrBlank()) { "로또 번호를 반드시 입력해야 합니다." }
        val numbers = numberLine.replace(WHITESPACE_REGEX, EMPTY_STRING).split(",").map { it.parseInt() }
        return LottoCard(numbers)
    }

    fun validatePassiveCnt(passiveCnt: String?, lottoCnt: Int): Int {
        require(!passiveCnt.isNullOrBlank()) { "수동으로 구매할 로또 수를 입력해 주세요." }

        val cnt = passiveCnt.parseInt()
        require(cnt >= 0) { "숫자는 0보다 같거나 커야합니다." }
        require(cnt < lottoCnt) { "로또는 ${lottoCnt}개만 구입할수 있습니다." }

        return cnt
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
