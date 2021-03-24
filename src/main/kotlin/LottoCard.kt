class LottoCard {
    private val _numbers: List<LottoNumber>
    val numbers: List<LottoNumber>
        get() = _numbers.toList()

    constructor() {
        _numbers = LOTTO_NUMBERS.shuffled().subList(0, LOTTO_NUMBER_CNT).map { LottoNumber(it) }
        validateNumbers()
    }

    constructor(numbers: List<Int>) {
        this._numbers = numbers.map { LottoNumber(it) }
        validateNumbers()
    }

    private fun validateNumbers() {
        require(_numbers.size == LOTTO_NUMBER_CNT) { "로또 번호는 6개여야 합니다." }
    }

    fun getWinning(winningLottoCard: LottoCard, bonusNumber: LottoNumber): Winning {
        val count = _numbers.filter { winningLottoCard._numbers.contains(it) }.size
        return Winning.matchWinning(count, _numbers.contains(bonusNumber))
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

    fun getStatistic(beforeWeekLottoCard: LottoCard, bonusNumber: LottoNumber): Map<Winning, Int> {
        return cards.map { it.getWinning(beforeWeekLottoCard, bonusNumber) }
            .filter { it != Winning.NONE }.groupingBy { it }.eachCount()
    }
}
