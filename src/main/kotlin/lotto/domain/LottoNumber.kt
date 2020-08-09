package stringAddCalculator

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { INVALID_MESSAGE }
    }

    override fun toString() = "$number"

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val INVALID_MESSAGE = "로또는 1~45사이의 숫자만 생성가능합니다."
    }
}
