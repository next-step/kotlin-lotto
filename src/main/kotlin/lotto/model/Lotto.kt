package lotto.model

data class Lotto(private val lottoNumbers: Set<LottoNumber>) {
    var lottoNums: Set<LottoNumber>
        private set

    init {
        require(isUniqueSixNumbers(lottoNumbers)) { "로또 번호는 서로 다른 6개의 숫자여야만 합니다." }
        lottoNums = lottoNumbers
    }

    constructor(numbers: Collection<Int>) : this(numbers.map(::LottoNumber).toSet())

    constructor(stringNumbers: String) : this(splitByComma(stringNumbers))

    fun getWinningCount(winningNumbers: List<Int>): Int {
        return lottoNums.count { winningNumbers.contains(it.number) }
    }

    override fun toString(): String {
        return lottoNumbers.map { it.number }.joinToString(COMMA_WITH_BLANK)
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val COMMA = ","
        private const val COMMA_WITH_BLANK = "$COMMA "

        private fun isUniqueSixNumbers(lottoNumbers: Set<LottoNumber>): Boolean {
            val size = lottoNumbers.size
            return (size == LOTTO_SIZE)
        }

        private fun splitByComma(stringNumbers: String): List<Int> {
            return stringNumbers
                .split(COMMA)
                .map { it.trim().toInt() }
        }
    }
}
