package lotto.domain

data class LottoNumbers(val values: List<LottoNumber>) {
    init {
        require(values.size == LOTTO_SIZE)
    }

    fun countMatchingNumbers(winningNumbers: LottoNumbers) =
        values.count { winningNumbers.values.contains(it) }

    companion object {
        fun List<Int>.toNumbers(): LottoNumbers {
            return LottoNumbers(this.map { LottoNumber(it) })
        }
    }
}