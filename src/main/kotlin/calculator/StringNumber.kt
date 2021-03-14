package calculator

data class StringNumber(val number: String) {
    init {
        if (number.toInt() < MINIMUM_NUMBER) throw RuntimeException("숫자는 $MINIMUM_NUMBER 보다 작을 수 없습니다.")
    }

    fun toInt(): Int {
        return number.toInt()
    }

    override fun toString(): String {
        return number
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
    }
}
