package lotto.domain

data class LottoNumber(val value: Int) {
    init {
        check(value in MINIMUM_NUMBER..MAXIMUM_NUMBER) { println("1~45 사이의 숫자를 입력해 주세요") }
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
        val NUMBERS = MINIMUM_NUMBER..MAXIMUM_NUMBER
    }
}
