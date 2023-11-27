package lotto.model

class WinningNumbers private constructor(
    private val lottoNumbers: LottoNumbers
) {
    fun match(target: LottoNumbers): Int {
        return lottoNumbers.match(target)
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in lottoNumbers
    }

    companion object {
        fun create(numbers: List<Int>): WinningNumbers {
            val lottoNumbers = LottoNumbers.create(numbers)

            return WinningNumbers(lottoNumbers)
        }
    }
}
