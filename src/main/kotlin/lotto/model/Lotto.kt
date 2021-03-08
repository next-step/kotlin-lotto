package lotto.model

data class Lotto(private val lottoNumbers: Set<LottoNumber>) {
    var lottoNums: Set<LottoNumber>
        private set

    init {
        require(isUniqueSixNumbers(lottoNumbers)) { "로또 번호는 서로 다른 6개의 숫자여야만 합니다." }
        lottoNums = lottoNumbers
    }

    constructor(numbers: Collection<Int>) : this(numbers.map(::LottoNumber).toSet())

    constructor(stringNumbers: String) : this(Delimiter(stringNumbers).split().map { it.toInt() })

    fun getWinningCount(winningNumbers: Lotto): Int {
        return lottoNums.count { winningNumbers.lottoNums.contains(it) }
    }

    fun hasBonusNumber(bonusNumber: LottoNumber): Boolean {
        return lottoNums.contains(bonusNumber)
    }

    fun getResult(winningLotto: Lotto, bonusNumber: LottoNumber): Coincidence? {
        return Coincidence.values()
            .find { it.coincidenceCount == getWinningCount(winningLotto) && it.hasBonusNum == hasBonusNumber(bonusNumber) }
    }

    override fun toString(): String {
        return lottoNumbers
            .sortedBy { it.number }
            .map { it.number }
            .joinToString(COMMA_WITH_BLANK)
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val COMMA = ","
        private const val COMMA_WITH_BLANK = "$COMMA "

        private fun isUniqueSixNumbers(lottoNumbers: Set<LottoNumber>): Boolean {
            val size = lottoNumbers.size
            return (size == LOTTO_SIZE)
        }
    }
}
