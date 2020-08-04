package lotto.domain

import lotto.domain.Result.Companion.getResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ResultTest {

    @DisplayName("매칭성공 개수가 주어지면 조건에 따라 알맞은 객체를 반환한다")
    @Test
    fun `get result`() {
        assertThat(getResult(matchSuccess = 3)).isEqualTo(Result.FOURTH)
        assertThat(getResult(matchSuccess = 4)).isEqualTo(Result.THIRD)
        assertThat(getResult(matchSuccess = 5)).isEqualTo(Result.SECOND)
        assertThat(getResult(matchSuccess = 6)).isEqualTo(Result.FIRST)
        assertThat(getResult(matchSuccess = 0)).isEqualTo(Result.ELSE)
    }

    @DisplayName("매칭성공 개수가 주어지면 조건에 따라 알맞은 인덱스를 반환한다")
    @Test
    fun `matches index`() {
        assertThat(getResult(matchSuccess = 3).winningResultsIndex).isEqualTo(0)
        assertThat(getResult(matchSuccess = 4).winningResultsIndex).isEqualTo(1)
        assertThat(getResult(matchSuccess = 5).winningResultsIndex).isEqualTo(2)
        assertThat(getResult(matchSuccess = 6).winningResultsIndex).isEqualTo(3)
        assertThat(getResult(matchSuccess = 0).winningResultsIndex).isEqualTo(4)
    }
}
