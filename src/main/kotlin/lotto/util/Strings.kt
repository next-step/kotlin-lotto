package lotto.util

import lotto.model.data.ParseResult

fun String?.parseToInt(): ParseResult<Int> {
    return try {
        val intValue = this?.toInt() ?: return ParseResult.Error("null String")
        ParseResult.Value(intValue)
    } catch (e: NumberFormatException) {
        ParseResult.Error(e.message ?: "Not a number")
    }
}
