package advancedcalculate.domain

class Operand(value: Double = 0.0) {
    val value: Double

    init {
        if (value <= 0) {
            throw NumberFormatException("음수는 입력할 수 없습니다.")
        }
        this.value = value
    }
}
