package lotto.domain

@JvmInline
value class LottoNumber(
    private val number: Int
) {
    init {
        validateRange(number)
    }

    private fun validateRange(number: Int) {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "0~45 사이에 번호가 존재해야하 합니다."
        }
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}

