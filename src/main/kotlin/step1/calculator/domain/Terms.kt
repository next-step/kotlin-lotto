package step1.calculator.domain

class Terms private constructor(private val elements: List<Int>) {
    operator fun get(index: Int) = elements[index]

    fun sum(): Int = elements.sum()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Terms

        if (elements != other.elements) return false

        return true
    }

    override fun hashCode(): Int {
        return elements.hashCode()
    }

    companion object {
        private const val NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력하세요 : [%s]"
        private const val NEGATIVE_NUMBER_ERROR_MESSAGE = "양수만 입력하세요. : [%s]"

        fun of(target: List<String>): Terms = Terms(target.map { toTerm(it) })

        private fun toTerm(str: String): Int {
            val term = toInt(str)
            validateTerm(term)
            return term
        }

        private fun toInt(str: String): Int = str.toIntOrNull()
            ?: throw IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE.format(str))

        private fun validateTerm(term: Int) =
            require(isPositive(term)) { NEGATIVE_NUMBER_ERROR_MESSAGE.format(term) }

        private fun isPositive(term: Int): Boolean = term >= 0
    }
}
