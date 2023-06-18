package calculator.vo

data class Delimiters(
    private val delimiters: Set<Delimiter>,
) {
    private val delimiterPattern: Regex

    init {
        require(delimiters.isNotEmpty()) { "하나 이상의 구분자를 입력해주세요." }
        delimiterPattern = Regex("[${delimiters.joinToString("")}]")
    }

    fun split(target: String): List<String> {
        return target.split(delimiterPattern)
    }

    fun add(delimiter: Delimiter?): Delimiters {
        if (delimiter == null) return this
        return Delimiters(delimiters.plus(delimiter))
    }

    companion object {
        fun from(delimiters: Collection<Delimiter>): Delimiters {
            return Delimiters(
                delimiters.toSet()
            )
        }
    }
}

