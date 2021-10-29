package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MatchedCountTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 7, 100])
    fun `0~6 사이의 일치 개수를 입력하지 않으면 IllegalArgumentException을 발생시킨다`(input: Int) {
        Assertions.assertThatThrownBy {
            MatchedCount[input]
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 6])
    fun `일치 개수가 0, 1, 2, 3, 4, 6개 인 경우 MatchCount 객체가 정상적으로 생성되고, 보너스 번호를 체크할 필요는 없다`(input: Int) {
        val matchedCount = MatchedCount[input]

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.value).isEqualTo(input)
        assertThat(matchedCount.shouldCheckBonusNumber()).isFalse
    }

    @Test
    fun `일치 개수가 5개 인 경우 보너스 번호를 체크해야 한다`() {
        val matchedCount = MatchedCount[5]

        assertThat(matchedCount).isNotNull
        assertThat(matchedCount.value).isEqualTo(5)
        assertThat(matchedCount.shouldCheckBonusNumber()).isTrue
    }
}
