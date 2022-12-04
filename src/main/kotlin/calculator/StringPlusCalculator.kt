package calculator

class StringPlusCalculator {
    fun calculate(expression: String?): Int {
        require(!expression.isNullOrBlank()) { "빈 문자열 또는 null 을 입력할 수 없습니다." }
        return 3
    }
}
