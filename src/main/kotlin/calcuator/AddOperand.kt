package calcuator

import java.lang.IllegalArgumentException

@JvmInline
value class AddOperand private constructor(
    val value: Int
) {
    companion object {
        fun of(stringNumber: String): AddOperand =
            stringNumber
                .toIntOrNull()
                ?.let { AddOperand(it) }
                ?: throw IllegalArgumentException("피연산자는 정수여야 합니다")
    }
}
