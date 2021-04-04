package view

object ManualPickCountParser {
    fun parse(input: String): Int {
        val parsedInt = input.toIntOrNull() ?: return 0

        if (parsedInt < 0) {
            return 0
        }

        return parsedInt
    }
}
