package lotto.domain

const val PRICE_OF_LOTTO = 1000
private val PLAYER_REGULAR_EXPRESSION = "^(\\d{1,2},)+\\d{1,2}$".toRegex()

class LottoGame(gameMoney: String) {
    var lottos: List<Lotto> = listOf()
        private set
    val lottoPrizeStatics = LottoPrizeStatics()

    init {
        val count = getCountOfGame(gameMoney)
        createLottos(count)
    }

    fun execute(prizeNumberString: String) {
        val prizeLotto = getPrizeLotto(prizeNumberString)
        checkMatch(prizeLotto)
    }

    private fun createLottos(count: Int) {
        val generatedLottos = mutableListOf<Lotto>()
        repeat(count) { generatedLottos.add(LottoGenerator.createLotto()) }
        lottos = generatedLottos
    }

    private fun checkMatch(prizeLotto: Lotto) {
        lottoPrizeStatics.checkMatches(prizeLotto, lottos)
    }

    @Throws(NumberFormatException::class)
    private fun getCountOfGame(gameMoney: String): Int {
        val count = gameMoney.toInt() / PRICE_OF_LOTTO
        require(count > 0) { "$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요." }
        return count
    }

    private fun getPrizeLotto(prizeNumberString: String): Lotto {
        require(PLAYER_REGULAR_EXPRESSION.matches(prizeNumberString)) { "1~45 사이의 숫자와 `,`로 만 값을 입력해 주세요." }
        return Lotto(prizeNumberString)
    }
}
