class LottoCard {
    private val numbers: List<Int>

    constructor() {
        numbers = LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_CNT)
    }

    constructor(numberLine: String?) {
        this.numbers = validateLottoCard(numberLine)
    }

    private fun validateLottoCard(numberLine: String?): List<Int> {
        require(!numberLine.isNullOrBlank()) { "로또 번호를 반드시 입력해야 합니다." }

        val strNumbers = numberLine.replace(WHITESPACE_REGEX, EMPTY_STRING).split(",")
        require(strNumbers.size == LOTTO_NUMBER_CNT) { "로또 번호는 6개입니다." }

        val numbers = strNumbers.map { it.parseInt() }
        require(numbers.none { it < LOTTO_START_NUMBER || it > LOTTO_LAST_NUMBER }) { "입력된 숫자가 로또 번호의 범위 밖입니다." }

        return numbers
    }

    fun getMatchCount(winningLottoCard: LottoCard): Int {
        return numbers.filter { winningLottoCard.numbers.contains(it) }.size
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val LOTTO_NUMBER_CNT = 6
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_LAST_NUMBER = 45
        private val LOTTO_NUMBERS = (LOTTO_START_NUMBER..LOTTO_LAST_NUMBER).toList()
        private val WHITESPACE_REGEX = Regex("\\s")
        private const val EMPTY_STRING = ""
    }
}

class LottoCards(cnt: Int) {
    var cards: List<LottoCard> = (1..cnt).map { LottoCard() }
}
