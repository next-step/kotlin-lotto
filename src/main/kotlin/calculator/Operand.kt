package calculator

import java.lang.RuntimeException

@JvmInline
value class Operand(
    val number: Int
) {
    companion object {
        fun valueOf(content: String): Operand {
            val number = runCatching { content.toInt() }
                .onFailure { throw RuntimeException("${it.message} 정수와 구분자만 입력하여 주세요.") }
                .getOrThrow()
            return Operand(number)
        }
    }
}
