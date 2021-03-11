package lotto

import java.io.InputStreamReader
import java.io.StringReader

interface WinningNumber {
    val lottoNumbers: LottoNumbers

    class Console(
        question: String,
        readable: Readable = InputStreamReader(System.`in`)
    ) : WinningNumber {
        private val userInput: UserInput<List<Int>> = UserInput.IntList(question, readable)

        override val lottoNumbers: LottoNumbers
            get() = LottoNumbers(userInput.answer())

        constructor(question: String, numbers: String) : this(question, StringReader(numbers))
    }
}
