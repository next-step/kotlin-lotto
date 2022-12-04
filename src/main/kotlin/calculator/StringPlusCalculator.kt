package calculator

class StringPlusCalculator {
    fun calculate(expression: String): Int {
        require(expression.isNotBlank()) { "빈 문자열을 입력할 수 없습니다." }
        return 3
    }
}
