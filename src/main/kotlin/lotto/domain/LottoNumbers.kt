package lotto.domain

class LottoNumbers(numbers: List<Int>) {
    val numbers = numbers.map(::LottoNumber)

    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) { "로또당 중복되지 않는 6개의 숫자가 있어야합니다." }
    }

    fun calculateWinningCount(lottoNumbers: List<LottoNumber>): Int {
        return lottoNumbers.count {
            numbers.contains(it)
        }
    }

    companion object {
        private val LottoNumberRange = (1..45)

        fun random(): LottoNumbers {
            val randomNumbers = LottoNumberRange.toList().shuffled().take(6)
            return LottoNumbers(randomNumbers)
        }
    }
}
