package camp.nextstep.edu.step.step1.domain.expression

import java.lang.RuntimeException

@JvmInline
value class Expression(
    val value: String = ""
) {

    init {
        require(value.isNotEmpty()) { throw RuntimeException() }
    }

    fun splitExpression(): List<String> {
        return value.split("[,:]".toRegex())
    }

}
