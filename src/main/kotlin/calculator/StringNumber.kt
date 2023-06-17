package calculator

class StringNumber(
    val number: String
) {
    init {
        require(number.toInt() >= MINIMUM) {
            throw RuntimeException("$MINIMUM 보다 작을 수 없습니다.")
        }
    }

    companion object {
        private const val MINIMUM = 0
    }
}
