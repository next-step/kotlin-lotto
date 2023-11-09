package lotto.model

class WinningNumbers private constructor(
    private val lottoNumbers: LottoNumbers
) {
    fun match(target: LottoNumbers): Int {
        return lottoNumbers.match(target)
    }

    companion object {
        fun create(numbers: List<Int>): WinningNumbers {
            val lottoNumbers = LottoNumbers(numbers)

            return WinningNumbers(lottoNumbers)
        }
    }
}
