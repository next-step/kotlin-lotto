package calculator

import java.lang.RuntimeException

data class Operand(
    val number: Int
) {
    companion object {
        fun valueOf(content: String): Int {
            return runCatching { content.toInt() }
                .onFailure { throw RuntimeException("정수와 구분자만 입력하여 주세요.") }
                .getOrThrow()
        }
    }
}
