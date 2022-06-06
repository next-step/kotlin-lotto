package addingCalculator.entity

import java.lang.RuntimeException

class CustomParserImpl : Parser {
    override fun parse(notation: String): List<String> {
        return Regex("//(.)\n(.*)").find(notation)?.let {
            it.groupValues[2].split(it.groupValues[1])
        } ?: throw RuntimeException()
    }
}
