package calculator

class Calculator {
    fun sum(numbers: List<Int>): Int {
        require(numbers.all { it >= 0 }) { "0 이상의 수만 계산 가능합니다" }
        return numbers.sum()
    }
}
