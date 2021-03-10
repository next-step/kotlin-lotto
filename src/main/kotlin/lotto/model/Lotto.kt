package lotto.model

data class Lotto(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(isUniqueSixNumbers(lottoNumbers)) { "로또 번호는 서로 다른 6개의 숫자여야만 합니다." }
    }

    constructor(numbers: Collection<Int>) : this(numbers.map(::LottoNumber).toSet())

    constructor(inputBeforeSplit: String) : this(Delimiter(inputBeforeSplit).split().map { it.toInt() })

    fun getMatchCount(winningLotto: Lotto): Int {
        return lottoNumbers.count { winningLotto.hasNumber(it) }
    }

    fun hasNumber(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    fun getResult(winningLotto: Lotto, bonusNumber: LottoNumber): Coincidence? {
        return Coincidence.values()
            .find { it.coincidenceCount == getMatchCount(winningLotto) && it.hasBonusNum == hasNumber(bonusNumber) }
    }

    override fun toString(): String {
        return lottoNumbers
            .map { it.number }
            .sorted()
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
