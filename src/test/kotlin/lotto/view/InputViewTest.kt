package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest {
    @Test
    fun `숫자 포맷이 아닌 구매 금액을 입력받았다면, 입력 금액 검증을 요청했을 때, 에러를 던진다`() {
        // given :
        val inputData = "10000a"

        // when :
        val actual = runCatching { InputView.validateCash(inputData) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `구입 금액의 범위를 넘어가는 값을 입력 받는다면, 입력 금액 검증을 요청했을 때, 에러를 던진다`() {
        // given :
        val inpuData = "240000"

        val actual = runCatching { InputView.validateCash(inpuData) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `당첨 번호 입력값을 받는다면, , 콤마를 기준으로 리스트를 반환한다`() {
        // given :
        val inputData = "1,2,3,4,5,6"

        // when :
        val actual = InputView.splitInputData(inputData)

        // then :
        val expect = listOf("1", "2", "3", "4", "5", "6")
        assertThat(actual).isEqualTo(expect)
    }
}
