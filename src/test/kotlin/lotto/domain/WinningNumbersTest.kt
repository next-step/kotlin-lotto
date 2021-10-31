package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class WinningNumbersTest {
    @ParameterizedTest
    @EmptySource
    fun `당첨 번호에 빈 문자열을 입력하면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            WinningNumbers.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "aaa, 1, 2, 3, 4, 5",
            "테스트, 1, 2, 3, 4, 5",
            "!, 1, 2, 3, 4, 5",
            "/, 1, 2, 3, 4, 5"
        ]
    )
    fun `당첨 번호에 숫자가 아닌 값을 입력하면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            WinningNumbers.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1",
            "1, 2",
            "1, 2, 3",
            "1, 2, 3, 4",
            "1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7",
        ]
    )
    fun `당첨 번호가 6개가 아니면 IllegalArgumentException이 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            WinningNumbers.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1, 2, 3, 4, 5, 6",
            "21, 32, 43, 4, 15, 27"
        ]
    )
    fun `당첨 번호가 6개를 입력하면 정상적으로 WinningInfo 가 생성된다`(input: String) {
        val winningInfo = WinningNumbers.from(input)

        assertThat(winningInfo).isNotNull
        assertThat(winningInfo.size()).isEqualTo(LottoNumberPackage.LOTTO_GAME_NUMBER_COUNT)
    }
}
