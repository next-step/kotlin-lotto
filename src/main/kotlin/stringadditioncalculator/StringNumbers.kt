package stringadditioncalculator

class StringNumbers(private val stringNumbers: List<String>) : List<String> by stringNumbers {
    fun validate() {
        val isValidStringNumbers = stringNumbers.map { it.toIntOrNull() }
            .any { it == null || it < 0 }
        require(!isValidStringNumbers) { "문자열 계산기에 숫자 이외의 값 또는 음수를 전달할 수 없습니다." }
    }
}
