package addingCalculator.entity

import java.lang.RuntimeException

class Validator {

    fun checkNullOrEmpty(notation: String?): String {
        if (notation.isNullOrEmpty()) return "0"
        return notation
    }

    fun checkValidNumber(notationList: List<String>) {
        notationList.forEach { operand: String -> if (operand.toIntOrNull() == null || operand.toInt() < 0) throw RuntimeException() }
    }
}
