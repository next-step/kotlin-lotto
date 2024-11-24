package lotto

object NumberSplitter {
    private const val SEPARATOR = ","

    fun splitInput(input: String): List<String> {
        val result = input.split(SEPARATOR)
        require(result.isNotEmpty()) { "올바른 형식으로 입력해주세요. ex) 1,2,3" }
        return result
    }
}
