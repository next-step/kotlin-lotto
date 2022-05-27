package lotto

data class LottoNumber(val number: Int) {

    init {
        validate(number)
    }

    private fun validate(number: Int) {
        if (number <= ZERO) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
