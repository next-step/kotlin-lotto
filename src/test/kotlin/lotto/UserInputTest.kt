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

    @Test
    fun `쉼표로 구분된 숫자목록을 입력받는다`() {
        assertThat(UserInput.IntList("질문", "1,2,3,4\n").answer()).isEqualTo(listOf(1, 2, 3, 4))
    }

    interface UserInput<T> {
        fun answer(): T

        class Int(private val question: String, readable: Readable) : UserInput<kotlin.Int> {
            private val scanner: Scanner = Scanner(readable)

            constructor(question: String, answer: String) : this(question, StringReader(answer))

            override fun answer(): kotlin.Int {
                println(question)
                return scanner.nextInt()
            }
        }

        class IntList(private val question: String, readable: Readable) : UserInput<List<kotlin.Int>> {
            private val scanner: Scanner = Scanner(readable)

            constructor(question: String, answer: String) : this(question, StringReader(answer))

            override fun answer(): List<kotlin.Int> {
                println(question)
                return scanner.nextLine()
                    .split(",")
                    .map { it.toInt() }
            }
        }
    }
}
