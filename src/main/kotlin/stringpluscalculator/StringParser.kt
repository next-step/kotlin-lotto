package stringpluscalculator

object StringParser {
    fun parser(input: String): List<String> {
        return input.split("[,:]".toRegex())
    }
}
