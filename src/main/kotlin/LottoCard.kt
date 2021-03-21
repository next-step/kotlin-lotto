class LottoCard {
    private val numbers: List<Int>

    constructor() {
        numbers = LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_CNT)
        validateNumbers()
    }

    constructor(numbers: List<Int>) {
        this.numbers = numbers
        validateNumbers()
    }

    private fun validateNumbers() {
        require(numbers.size == LOTTO_NUMBER_CNT) { "로또 번호는 6개여야 합니다." }
        require(numbers.none { it < LOTTO_START_NUMBER || it > LOTTO_LAST_NUMBER }) { "입력된 숫자가 로또 번호의 범위 밖입니다." }
    }

    fun getWinning(winningLottoCard: LottoCard, bonusNumber: Int): Winning {
        val count = numbers.filter { winningLottoCard.numbers.contains(it) }.size
        return Winning.matchWinning(count, numbers.contains(bonusNumber))
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_NUMBER_CNT = 6
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_LAST_NUMBER = 45
        val LOTTO_NUMBERS = (LOTTO_START_NUMBER..LOTTO_LAST_NUMBER).toList()
    }
}

class LottoCards {
    private val _cards = mutableListOf<LottoCard>()
    val cards: List<LottoCard>
        get() = _cards.toList()

    fun addLottoCard(lottoCard: LottoCard) {
        _cards.add(lottoCard)
    }

    fun generateRandomLottoCard(cnt: Int) {
        repeat(cnt) {
            addLottoCard(LottoCard())
        }
    }

    fun getStatistic(beforeWeekLottoCard: LottoCard, bonusNumber: Int): Map<Winning, Int> {
        return cards.map { it.getWinning(beforeWeekLottoCard, bonusNumber) }
            .filter { it != Winning.NONE }.groupingBy { it }.eachCount()
    }
}
