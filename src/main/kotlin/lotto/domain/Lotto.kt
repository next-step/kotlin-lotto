package lotto.domain

class Lotto(val numbers: LottoNumbers) {
    init {
        require(numbers.lottoNumbers.all { it.number in (MINIMUM_NUMBER..MAXIMUM_NUMBER) }) { "LottoNumber must be between 1 and 45" }
        require(numbers.lottoNumbers.size == NUMBER_OF_NUMBER) { "로또는 정확히 6개의 숫자가 필요해요" }
    }

    companion object {
        const val NUMBER_OF_NUMBER = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val PRICE = 1_000
    }
}
