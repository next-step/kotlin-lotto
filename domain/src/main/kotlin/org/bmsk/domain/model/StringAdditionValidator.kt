package org.bmsk.domain.model

internal class StringAdditionValidator {
    fun validateFormat(realStringFormula: String, separators: Separators) {
        realStringFormula.forEach { char ->
            validateCharacter(char, separators)
        }
    }

    private fun validateCharacter(char: Char, separators: Separators) {
        if (char.isDigit()) return

        if (separators.contains(Separator(char.toString())).not()) {
            handleInvalidCharacter(char)
        }
    }

    private fun handleInvalidCharacter(char: Char) {
        when (char) {
            '-' -> throw IllegalArgumentException("[$char] 음수를 전달하면 안 됩니다.")
            else -> throw IllegalArgumentException("[$char] 숫자 이외의 값을 전달하면 안 됩니다.")
        }
    }
}
