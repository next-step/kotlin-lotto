package stringcalculator

class Separators(private val separators: List<Separator>) {
    constructor() : this(listOf(Separator(","), Separator(":")))

    fun addSeparator(value: String): Separators {
        validateBlank(value)
        if (isExist(value)) {
            return this
        }
        return Separators(separators + Separator(value))
    }

    private fun validateBlank(value: String) {
        require(value.isNotBlank()) { "구분자는 공백일 수 없습니다." }
    }

    fun isExist(value: String) = separators.any { it.isEqual(value) }
}
