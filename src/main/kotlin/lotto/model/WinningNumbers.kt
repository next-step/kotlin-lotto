package lotto.model

class WinningNumbers private constructor(
    private val lottoNumbers: LottoNumbers
) {
    fun match(target: LottoNumbers): Int {
        return lottoNumbers.match(target)
    }

    fun contain(number: Int): Boolean {
        return lottoNumbers.contain(number)
    }

    companion object {
        fun create(numbers: List<Int>): WinningNumbers {
            val lottoNumbers = LottoNumbers.create(numbers)

            return WinningNumbers(lottoNumbers)
        }
    }
}
