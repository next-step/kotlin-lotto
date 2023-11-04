package calculator

import java.lang.RuntimeException

class StringToIntConverter: Converter<String, Int> {

    override fun convert(input: String): Int =
        runCatching { input.toInt() }
            .onFailure { throw RuntimeException("정수와 구분자만 입력하여 주세요.") }
            .getOrThrow()
}
