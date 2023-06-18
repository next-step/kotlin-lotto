package lotto.domain

data class WinNumbers(private val winLotto: Lotto, private val bonusNumber: LottoNumber) {
    init {
        require(bonusNumber !in winLotto) { DUPLICATE_NUMBER_ERROR_MESSAGE }
    }

    constructor(numbers: List<Int>, bonusNumber: Int) : this(
        Lotto(numbers.map { LottoNumber(it) }.toSortedSet()),
        LottoNumber(bonusNumber)
    )

    fun getMatchCount(lotto: Lotto): Int = lotto.getMatchCount(this.winLotto)

    companion object {
        private const val DUPLICATE_NUMBER_ERROR_MESSAGE = "보너스 번호는 당첨 번호에 포함되지 않아야 합니다"
    }
}
