package lotto.domain

object LottoMachine {

    private val LOTTO_RANGE_NUMBERS = (1..45).map { it }
    private const val LOTTO_NUMBER = 6
    private const val LOTTO_PRICE = 1000

    const val LOTTO_WINNER_THREE = 5000
    const val LOTTO_WINNER_FOUR = 50000
    const val LOTTO_WINNER_FIVE = 1500000
    const val LOTTO_WINNER_SIX = 2000000000

    var lottoCount = 0
        private set

    var buyedLottoes = mutableListOf<List<Int>>()
        private set

    var threeCorrect = 0
        private set

    var fourCorrect = 0
        private set

    var fiveCorrect = 0
        private set

    var sixCorrect = 0
        private set

    var rateOfReturn = 0.0
        private set

    private var myAmount = 0

    private val totalWinAmount: Int
        get() = LOTTO_WINNER_THREE * threeCorrect + LOTTO_WINNER_FOUR * fourCorrect + LOTTO_WINNER_FOUR * fourCorrect + LOTTO_WINNER_FIVE * fiveCorrect + LOTTO_WINNER_SIX * sixCorrect

    fun buyLotto(amount: Int) {
        myAmount = amount
        lottoCount = amount / LOTTO_PRICE

        repeat(lottoCount) {
            buyedLottoes.add(LOTTO_RANGE_NUMBERS.shuffled().take(LOTTO_NUMBER).sorted())
        }
    }

    fun setWinNumbers(winNumbers: List<Int>) {
        buyedLottoes.forEach {
            checkWinNumber(it, winNumbers)
        }
        rateOfReturn = totalWinAmount.toDouble() / myAmount.toDouble()
    }

    private fun checkWinNumber(buyedLotto: List<Int>, winNumbers: List<Int>) {
        when (buyedLotto.filter { it in winNumbers }.size) {
            3 -> threeCorrect++
            4 -> fourCorrect++
            5 -> fiveCorrect++
            6 -> sixCorrect++
        }
    }
}
