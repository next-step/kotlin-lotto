package calculator

import calculator.vo.Delimiters

object Tokenizer {
    fun tokenize(input: String, delimiters: Delimiters): List<String> {
        return delimiters.split(input)
    }
}
