package lotto.domain.model

import lotto.view.inputconverter.InputConverter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UserInputRequestTest {
    @Test
    fun `UserInputRequest는 사용자에게 입력을 요청하기 위한 정보를 보관한다`() {
        val message = "입력해 주세요."
        val inputConverter = object : InputConverter<String> {
            override fun convert(input: String?): UserInputResult<String> {
                return UserInputResult.Success(input ?: "")
            }
        }
        val retryMessage = "입력이 잘못됐습니다. 다시 입력해 주세요"
        val userInputRequest = UserInputRequest(
            message,
            inputConverter,
            retryMessage
        )

        assertAll(
            { assertThat(userInputRequest.message).isEqualTo(message) },
            { assertThat(userInputRequest.inputConverter).isEqualTo(inputConverter) },
            { assertThat(userInputRequest.retryMessage).isEqualTo(retryMessage) }
        )
    }
}
