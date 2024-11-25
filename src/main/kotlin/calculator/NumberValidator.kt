package calculator

class NumberValidator {
    fun validate(numbers: List<Int>) {
        val negativeNumbers = numbers.filter { it < 0 }
        if (negativeNumbers.isNotEmpty()) {
            throw RuntimeException("음수는 허용되지 않습니다.")
        }
    }
}


