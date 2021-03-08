package lotto

import java.io.InputStreamReader
import java.io.StringReader

interface WinningNumber {
    val lottoNumber: LottoNumber

    class Console(
        question: String,
        readable: Readable = InputStreamReader(System.`in`)
    ) : WinningNumber {
        private val userInput: UserInput<List<Int>> = UserInput.IntList(question, readable)

        override val lottoNumber: LottoNumber
            get() = LottoNumber(userInput.answer())

        constructor(question: String, numbers: String) : this(question, StringReader(numbers))
    }
}
