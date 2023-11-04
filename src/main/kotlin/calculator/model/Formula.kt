package calculator.model

data class Formula(
    val tokens: ArrayDeque<Token>
) {
    fun sum(): Token {
        return tokens
            .reduce { i, t -> i.add(t) }
    }

    constructor(l: List<Int>) : this(ArrayDeque(l.map { Token(it) }))

    companion object {
        fun emptyOf(): Formula {
            return Formula(listOf())
        }
    }
}
