package calculator.adder.value

class PositiveNumber(_value: String?) {
    val value = parse(_value)

    private fun parse(value: String?): Int {
        return value?.toIntOrNull()
            ?.checkPositive()
            ?: throw IllegalArgumentException("null 은 계산할 수 없습니다.")
    }

    private fun Int.checkPositive() = with(this) {
        if (this < 0) {
            throw IllegalArgumentException("음수($this)는 계산할 수 없습니다.")
        }
        this
    }
}
