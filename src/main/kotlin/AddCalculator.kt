class AddCalculator {
    fun sum(input: String): Int {
        val inputValidator = InputValidator()
        val inputParser = InputParser()

        val tokens = inputParser.parse(input)

        tokens.forEach {
            inputValidator.checkNatualAndZero(it)
        }

        val numbers = tokens.map { it.toInt() }

        return sum(numbers)
    }

    private fun sum(numbers: List<Int>): Int {
        return numbers.sum()
    }
}
