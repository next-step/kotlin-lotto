package lotto.domain

data class Numbers(val values: List<LottoNumber>) {
    init {
        require(values.size == LOTTO_SIZE)
    }

    fun countMatchingNumbers(winningNumbers: Numbers) =
        values.count { winningNumbers.values.contains(it) }

    companion object {
        fun List<Int>.toNumbers(): Numbers {
            return Numbers(this.map { LottoNumber(it) })
        }
    }
}