package lotto.domain

class Lotto(val numbers: LottoNumbers) {
    companion object {
        const val NUMBER_OF_NUMBER = 6
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val PRICE = 1_000
    }
}
