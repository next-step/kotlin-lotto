package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ResultsTest {
    private lateinit var totalResults: Results

    @BeforeEach
    fun `set up`() {
        totalResults = Results(
            listOf(
                Result.FOURTH,
                Result.THIRD,
                Result.SECOND,
                Result.FIRST
            )

        )
    }

    @DisplayName("모든 결과의 당첨 정보를 파악하고, 리스트에 당첨 결과 정보를 저장하여 반환한다")
    @Test
    fun `winning results`() {
        assertThat(totalResults.winningResults).isEqualTo(listOf(1, 1, 1, 1))
    }

    @DisplayName("toString()을 하면, 당첨 통계 정보(당첨 조건, 당첨금, 총수익률)를 반환한다")
    @Test
    fun `print toString`() {
        print(totalResults.toString())
    }
}
