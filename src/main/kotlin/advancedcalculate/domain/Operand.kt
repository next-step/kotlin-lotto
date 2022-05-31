package advancedcalculate.domain

class Operand(value: Double = 0.0) {
    val value: Double

    init {
        require(value > 0) {
            "음수는 입력할 수 없습니다."
        }
        this.value = value
    }

    operator fun plus(target: Operand): Operand {
        return Operand(value + target.value)
    }
}
