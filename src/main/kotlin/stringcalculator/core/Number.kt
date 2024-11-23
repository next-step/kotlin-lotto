package stringcalculator.core

class Number(value: String) {
    var number = 0
        private set

    init {
        number = value.toIntOrNull() ?: throw RuntimeException("잘못된 값이 입력되었습니다.")
        if (number < 0) {
            throw RuntimeException("입력된 값이 음수 입니다.")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Number) return false
        return this.number == other.number
    }

    override fun hashCode(): Int {
        return 31 * number
    }
}
