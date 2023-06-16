package calculator

import java.lang.RuntimeException

class Operand(arg: String) {
    val value: Int
    init {
        try {
            value = arg.toInt()
        } catch (e: Exception) {
            throw RuntimeException()
        }

        if (value < 0) {
            throw RuntimeException()
        }
    }
}
