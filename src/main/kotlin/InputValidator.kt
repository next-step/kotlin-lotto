object InputValidator {
    fun checkNullOrBlank(input: String?): Boolean = input.isNullOrBlank()

    @Throws(RuntimeException::class)
    fun validate(input: List<String>) {
        val tokens = input.toIntList()

        if (tokens.isEmpty() || tokens.any { it < 0 }) {
            throw RuntimeException("입력 값이 잘못되었습니다")
        }
    }

    @Throws(RuntimeException::class)
    private fun List<String>.toIntList(): List<Int> = try {
        this.map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw RuntimeException("입력 값이 잘못되었습니다")
    }
}
