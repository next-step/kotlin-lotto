package calculator

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

object Expression {
    @OptIn(ExperimentalContracts::class)
    fun isEmptyExpression(text: String?): Boolean {
        contract {
            returns() implies (text != null)
        }
        return (text == null) || text.trim().isEmpty()
    }

    fun getExpression(text: String): String {
        if (Delimiter.existCustomizedDelimiter(text)) {
            return text.substring(Delimiter.getIndexOfAfterFlag(text))
        }
        return text
    }

    fun splitExpression(text: String, delimiters: List<String>): List<String> {
        return text.split(*delimiters.toTypedArray())
    }

}