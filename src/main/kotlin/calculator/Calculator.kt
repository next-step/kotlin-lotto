package calculator

object Calculator {
    fun calculate(input: String?): Int {
        if(input.isNullOrBlank()) {
            return 0
        }
        return input.split(",")
            .sumOf{ it.toInt() }
    }
}