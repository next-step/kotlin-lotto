package lotto.domain

class WinningNumbers private constructor(val numbers: List<LottoNumber>) {

    fun countMatchingNumbers(lotto: Lotto): Int {
        return numbers.count { lotto.contains(it) }
    }

    companion object {
        fun of(numbers: List<Int>): WinningNumbers {
            val lottoNumbers = numbers.distinct().map { LottoNumber(it) }

            require(lottoNumbers.size == 6) { "당첨 번호는 총 6개 이어야 합니다." }

            return WinningNumbers(lottoNumbers)
        }
    }
}
