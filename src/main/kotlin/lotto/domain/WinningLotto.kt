package lotto.domain

data class WinningLotto(val lottoNumbers: LottoNumbers) {
    fun countMatchedNumber(other: Lotto): Int {
        return lottoNumbers.countMatchedNumber(other.lottoNumbers)
    }

    companion object {
        fun create(numbers: List<Int>): WinningLotto {
            return WinningLotto(LottoNumbers(numbers.toSet()))
        }
    }
}
