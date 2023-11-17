package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputViewTest {
    @Test
    fun `숫자 포맷이 아닌 구매 금액을 입력받았다면, 입력 금액 검증을 요청했을 때, 에러를 던진다`() {
        // given : 숫자 포맷이 아닌 구매 금액을 입력는다.
        val inputData = "10000a"

        // when : 입력 금액에 대한 검증을 요청한다.
        val actual = runCatching { InputView.validateCash(inputData) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `구입 금액의 범위를 넘어가는 값을 입력 받는다면, 입력 금액 검증을 요청했을 때, 에러를 던진다`() {
        // given : 구매 금액 범위를 넘어가는 값을 입력 받는다면
        val inpuData = "240000"

        // when : 입력 금액에 대한 검증을 요청한다.
        val actual = runCatching { InputView.validateCash(inpuData) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `당첨 번호 입력값을 받는다면, 콤마를 기준으로 문자열 분리요청을 했을 때, 리스트를 반환한다`() {
        // given : 당청 번호를 입력 받는다.
        val inputData = "1,2,3,4,5,6"

        // when : 콤마를 기준으로 문자열 분리 요청을 한다.
        val actual = InputView.splitInputData(inputData)

        // then : 리스트를 반환한다.
        val expect = listOf(1, 2, 3, 4, 5, 6)
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `숫자가 아닌 값이 포함된 당첨 번호 입력값을 받는다면, 분리 요청을 했을 때, 에러를 던진다`() {
        // given : 숫자가 아닌 값이 포함된 당첨 번호를 입력 받는다.
        val inputData = "1,2,3,4,5,6h"

        // when : 콤마를 기준으로 문자열 분리 요청을 한다.
        val actual = runCatching { InputView.splitInputData(inputData) }.exceptionOrNull()

        // then : 에러를 던진다.
        assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
