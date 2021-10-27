package calculator

class SplitHelper(
    private val delimiter: String
) {

    fun split(input: String): List<String> = input.split(delimiter)
}
