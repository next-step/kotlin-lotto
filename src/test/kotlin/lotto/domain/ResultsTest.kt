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

    @DisplayName("각 결과마다 어떻게 당첨이 됐는지 확인하고, 이에 대한 정보를 리스트에 저장하여 반환한다")
    @Test
    fun `match results`() {
        assertThat(totalResults.matchResults).isEqualTo(listOf(1, 1, 1, 1))
    }

    @DisplayName("toString()을 하면, 당첨 통계 정보(당첨 조건, 당첨금, 총수익률)를 반환한다")
    @Test
    fun `print toString`() {
        print(totalResults.toString())
    }
}
