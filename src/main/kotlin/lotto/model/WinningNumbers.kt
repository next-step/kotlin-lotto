package lotto.model

data class WinningNumbers(val winningNumbers: LottoNumbers) : List<LottoNumber> by winningNumbers {
    companion object {
        fun from(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(LottoNumbers.from(numbers))
        }
    }
}
