package calculator

class Params(text: String?) {
    val paramList: List<Param>

    init {
        paramList = if (text.isNullOrBlank()) {
            listOf(Param.EMPTY_PARAM)
        } else {
            val tokens = split(text)
            tokens.map { Param(it) }
        }
    }

    fun fold(operation: (Int, Int) -> Int): Param {
        return paramList.fold(Param.EMPTY_PARAM) {
            acc: Param, param: Param ->
            acc.operation(param, operation)
        }
    }

    private fun split(text: String): List<String> {
        val result = TOKEN_SPLITTER.find(text)
        return result?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(DEFAULT_DELIMITER)
    }

    companion object {
        private val DEFAULT_DELIMITER: Regex = "[,:]".toRegex()
        private val TOKEN_SPLITTER = "//(.)\n(.*)".toRegex()
    }
}
