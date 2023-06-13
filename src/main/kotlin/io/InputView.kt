package io

object InputView {
    private val DEFAULT_SEPARATORS = "[,:]".toRegex()
    fun getExpression(): List<String> {
        println("수식을 입력하세요.")
        val input = readlnOrNull()
        if (input.isNullOrEmpty()) {
            return listOf("0")
        }
        return input.split(DEFAULT_SEPARATORS)
    }
}
