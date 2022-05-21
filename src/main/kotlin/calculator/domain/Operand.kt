package calculator.domain

import calculator.constants.Messages

/**
 * 피연산자를 저장하는 클래스
 * Created by Jaesungchi on 2022.05.21..
 */
data class Operand(val value: Int) {
    init {
        if (value < MINIMUM_VALID_NUMBER) throw RuntimeException(Messages.INSERT_NEGATIVE_NUMBER)
    }

    operator fun plus(another: Operand): Operand {
        return Operand(value + another.value)
    }

    companion object {
        private const val MINIMUM_VALID_NUMBER = 0

        fun of(stringValue: String): Operand {
            val value = stringValue.toIntOrNull() ?: throw RuntimeException(Messages.INSERT_NOT_NUMBER)
            return Operand(value)
        }
    }
}
