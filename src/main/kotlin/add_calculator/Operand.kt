package add_calculator

import java.lang.RuntimeException

class Operand(text: String) {
    private val value: UInt

    init {
        value = text.toUIntOrNull() ?: throw RuntimeException()
    }
}
