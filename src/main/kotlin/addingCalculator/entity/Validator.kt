package addingCalculator.entity

import java.lang.RuntimeException

class Validator {
    fun validate(notationList: List<String>) {
        notationList.forEach { operand: String -> if (operand.toIntOrNull() == null || operand.toInt() < 0) throw RuntimeException() }
    }
}
