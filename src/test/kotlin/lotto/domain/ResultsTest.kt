package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
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

    @Test
    fun `get matches`() {
        assertThat(totalResults.matchResults).isEqualTo(listOf(1, 1, 1, 1))
    }

    @Test
    fun `print toString`() {
        print(totalResults.toString())
    }
}
