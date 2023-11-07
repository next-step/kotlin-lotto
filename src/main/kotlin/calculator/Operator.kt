package calculator

class Operator {
    fun add(numbers: List<Int>): Int {
        return numbers.sumOf { number ->
            if (number < 0) {
                throw RuntimeException("음수가 들어올 수 없습니다.")
            }
            number
        }
    }
}
