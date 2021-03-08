package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.StringReader
import java.util.Scanner

class UserInputTest {
    @Test
    fun `숫자를 입력받는다`() {
        assertThat(UserInput.Int("질문", "14000\n").answer()).isEqualTo(14_000)
    }

    interface UserInput {
        fun answer(): kotlin.Int

        class Int(private val question: String, readable: Readable) : UserInput {
            private val scanner: Scanner = Scanner(readable)
            override fun answer(): kotlin.Int {
                println(question)
                return scanner.nextInt()
            }

            constructor(question: String, answer: String) : this(question, StringReader(answer))
        }
    }
}
