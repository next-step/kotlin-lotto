package lotto.view.input

import lotto.view.input.parser.InputParser

object ConsoleReader {

    fun <T> read(message: String, inputParser: InputParser<T>): T {
        println(message)
        return tryToRead(inputParser) ?: read(message, inputParser)
    }

    private fun <T> tryToRead(inputParser: InputParser<T>) = try {
        parseString(readLine(), inputParser)
    } catch (e: Exception) {
        println(e.message)
        null
    }

    private fun <T> parseString(inputString: String?, inputParser: InputParser<T>) =
        if (inputString.isNullOrBlank()) null else inputParser.parseValue(inputString)
}
