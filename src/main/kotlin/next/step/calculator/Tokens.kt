package next.step.calculator

@JvmInline
value class Tokens(private val tokens: List<String>) : List<String> by tokens
