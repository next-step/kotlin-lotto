package lotto

import lotto.LottoDrawMachineTest.LottoNumber
import lotto.UserInputTest.UserInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.InputStreamReader
import java.io.StringReader

class WinningNumberTest {
    @Test
    fun `당첨번호가 있다`() {
        assertThat(WinningNumber.Console("지난 주 당첨 번호를 입력해 주세요.", "1,2,3,4,5,6\n").lottoNumber)
            .isEqualTo(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
    }

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
}
