package calculator

class StringAddCalculator(private val parser: InputParser) {
    fun add(input: String): Int {
        return parser.inputParse(input).sumOf {
            it.toInt()
        }
    }
}

