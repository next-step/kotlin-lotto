package stringAddCalculatorTest

import org.junit.jupiter.api.extension.ParameterContext
import org.junit.jupiter.params.converter.ArgumentConversionException
import org.junit.jupiter.params.converter.ArgumentConverter

class IntegerListConverter : ArgumentConverter {
    @Throws(ArgumentConversionException::class)
    override fun convert(source: Any, context: ParameterContext): List<Int> {
        require(source is String) { "The argument should be a string: $source" }
        println("source: $source")
        return try {
            source.split(",").map { it.toInt() }
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to convert", e)
        }
    }
}
