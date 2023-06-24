package step2Lotto.domain

class LottoNumber {
    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = (MINIMUM_NUMBER..MAXIMUM_NUMBER).toList()
    }
}
