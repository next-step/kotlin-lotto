package calculator

object Calculator {
    fun add(input: String?): Int {
        if (input.isNullOrEmpty())
            return 0
        val inputValues = splitInput(input)
        return sumValues(inputValues)
    }

    private fun splitInput(input: String): List<String> = input.split(',', ':')

    private fun sumValues(inputValues: List<String>): Int = inputValues.sumOf { it.toInt() }
}
