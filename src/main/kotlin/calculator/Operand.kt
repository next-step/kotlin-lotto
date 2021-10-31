package calculator

import java.lang.RuntimeException

class Operand(val value: Int) {
    constructor(stringValue: String) : this(stringValue.toInt()) {
        checkStringValueIsNumber(stringValue)
    }

    private fun checkStringValueIsNumber(stringValue: String) {
        if (!stringValue.matches(unsignedNumberRegex))
            throw RuntimeException()
    }

    companion object {
        private val unsignedNumberRegex = "\\d".toRegex()
    }
}
