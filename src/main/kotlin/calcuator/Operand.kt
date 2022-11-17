package calcuator

class Operand(val number: Int) {
    init {
        if (number < 0) throw RuntimeException("음수를 입력 할 수 없습니다.")
    }
}
