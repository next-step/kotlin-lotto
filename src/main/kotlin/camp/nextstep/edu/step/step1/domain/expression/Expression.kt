package camp.nextstep.edu.step.step1.domain.expression

@JvmInline
value class Expression(
    val value: String = ""
) {

    init {
        require(value.isNotEmpty()) { throw RuntimeException() }
        validateNegativeExpression()
    }

    fun splitExpression(): List<String> {
        return value.split("[,:]".toRegex())
    }

    private fun validateNegativeExpression() {
        if (value.contains("-")) {
            throw RuntimeException()
        }
    }

}
