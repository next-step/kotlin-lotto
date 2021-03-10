package stringaddcalculator.domain

data class Operand(val number: Int) {
    init {
        require(number >= 0) { "음수는 입력할 수 없습니다." }
    }

    operator fun plus(other: Operand): Operand = Operand(number + other.number)

    companion object {
        fun of(stringNumber: String) =
            Operand(stringNumber.toIntOrNull() ?: throw IllegalArgumentException("$stringNumber : 올바르지 않은 피연산자 타입입니다"))
    }
}
