package calculator.component

import calculator.model.Token

data class Formula(
    val tokens: ArrayDeque<Token>
) {
    constructor(l: List<Int>) : this(ArrayDeque(l.map { Token(it) }))

    companion object {
        fun emptyOf(): Formula {
            return Formula(listOf())
        }
    }
}
