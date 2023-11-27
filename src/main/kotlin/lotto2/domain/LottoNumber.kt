package lotto2.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        validateRange()
    }

    private fun validateRange() {
        require(number in MINIMUM_NUMBER..MAXIMUM_NUMBER) { "로또 번호는 1 ~ 45 사이의 숫자만 가능합니다." }
    }

    companion object {
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
