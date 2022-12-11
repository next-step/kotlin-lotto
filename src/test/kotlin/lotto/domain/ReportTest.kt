package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReportTest {

    @Test
    fun `기본으로 생성된 리포트는 모두 0이다`() {
        assertThat(Report()).isEqualTo(
            Report(
                missCount = 0,
                fourthCount = 0,
                thirdCount = 0,
                secondCount = 0,
                firstCount = 0
            )
        )
    }
}
