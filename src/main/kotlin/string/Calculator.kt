package string

class Calculator() {
    fun sum(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val inputs = parse(input)
        if (inputs.size == ONE_NUMBER_SIZE) {
            return inputs[0].toInt()
        }

        return 1
    }

    private fun parse(input: String): List<String> {
        return validateEach(split(input))
    }

    private fun split(input: String): List<String> {
        return input.split(DELIMITER_REGEX.toRegex())
    }

    private fun validateEach(inputs: List<String>): List<String> {
        for (input in inputs) {
            validateEachInput(input)
        }

        return inputs
    }

    private fun validateEachInput(input: String) {
        val num = input.toIntOrNull()

        if (num == null || num < 0) {
            throw RuntimeException("음수 혹은 숫자가 아닌 값이 들어왔습니다")
        }
    }

    companion object {
        private const val DELIMITER_REGEX = ",|:"
        private const val ONE_NUMBER_SIZE = 1
    }
}
