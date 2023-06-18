package string

import string.converter.ExpressionTokenConverter
import string.splitter.DefaultSeparatorStringSplitter
import string.splitter.RegexBasedCustomSeparatorStringSplitter

fun main() {
    val tokenConverter = ExpressionTokenConverter()
    val splitters = listOf(
        RegexBasedCustomSeparatorStringSplitter(tokenConverter),
        DefaultSeparatorStringSplitter(tokenConverter)
    )
    val sut = StringCalculator(splitters)
    println(sut.sum("1,2,3,4,5,6,7,8,9,10"))
}
