package lotto.model

data class LottoNumbers(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(isUniqueSixNumbers(lottoNumbers)) {"로또 번호는 서로 다른 6개의 숫자여야만 합니다."}
    }

    constructor(numbers: Collection<Int>): this(numbers.map(::LottoNumber))

    fun getWinningCount(winningNumbers: List<Int>): Int {
        return lottoNumbers.filter { winningNumbers.contains(it.number) }.count()
    }

    companion object {
        private const val LOTTO_SIZE = 6

        private fun isUniqueSixNumbers(lottoNumbers: List<LottoNumber>): Boolean {
            val size = lottoNumbers.sortedBy { it.number }.toSet().size
            return (size == LOTTO_SIZE)
        }
    }
}
