package caculator

import caculator.domain.Numbers
import caculator.domain.Splitter

class StringAddCalculator {
    fun add(expression: String?): Int =
        expression.takeIf { !it.isNullOrBlank() }
            ?.let(::Splitter)
            ?.split()
            ?.let(Numbers::invoke)
            ?.sum() ?: 0
}
