package lotto.domain

const val PRICE_OF_LOTTO = 1000
private val PLAYER_REGULAR_EXPRESSION = "^(\\d{1,2},)+\\d{1,2}$".toRegex()

class LottoGame(gameMoney: String) {
    var lottoList: List<Lotto> = listOf()
        private set
    val lottoPrizeStatics = LottoPrizeStatics()

    init {
        val count = getCountOfGame(gameMoney)
        createLottoList(count)
    }

    fun execute(prizeNumberString: String, _bonusNumber: String) {
        val prizeLotto = getPrizeLotto(prizeNumberString)
        val bonusNumber = LottoNumber(_bonusNumber.toInt())
        require(!prizeLotto.isContain(bonusNumber))
        checkMatch(prizeLotto, bonusNumber)
    }

    private fun createLottoList(count: Int) {
        val generateLottoList = mutableListOf<Lotto>()
        repeat(count) { generateLottoList.add(LottoGenerator.createLotto()) }
        lottoList = generateLottoList
    }

    private fun checkMatch(prizeLotto: Lotto, bonusNumber: LottoNumber) {
        lottoPrizeStatics.checkMatches(prizeLotto, bonusNumber, lottoList)
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
