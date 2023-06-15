object InputValidator {
    @Throws(RuntimeException::class)
    fun validate(input: List<String>) {
        val tokens = input.map { it.toIntOrNull() }

        if (tokens.isEmpty() || tokens.any { it == null || it.toInt() < 0 }) {
            throw RuntimeException("입력 값이 잘못되었습니다")
        }
    }
}
