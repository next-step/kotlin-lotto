package calculator

data class Number(private val text: String) {
    var positive: Int = 0
        private set

    init {
        val intValue = text.ifEmpty { "0" }.toIntOrNull()

        requireNotNull(intValue) { NOT_STRING_MESSAGE }

        require(intValue >= MINIMUM_NUMBER) { NOT_NEGATIVE_MESSAGE }

        positive = intValue
    }

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val NOT_STRING_MESSAGE = "문자가 포함된 값은 사용할 수 없습니다."
        private const val NOT_NEGATIVE_MESSAGE = "0보다 작은 값은 사용할 수 없습니다."
    }
}
