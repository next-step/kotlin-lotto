package lotto.domain

data class WinningLotto(val lottoNumbers: LottoNumbers) {
    fun countMatchedNumber(other: Lotto): Int {
        return lottoNumbers.countMatchedNumber(other.lottoNumbers)
    }

    companion object {
        fun create(numbers: Set<Int>): WinningLotto {
            return WinningLotto(LottoNumbers.from(numbers))
        }
    }
}
