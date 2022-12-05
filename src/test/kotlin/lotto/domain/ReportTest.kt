package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReportTest {

    @Test
    fun `기본으로 생성된 리포트는 모두 0이다`() {
        assertThat(Report()).isEqualTo(
            Report(
                notWin = NotWin(0),
                fourthWin = FourthWin(0),
                thirdWin = ThirdWin(0),
                secondWin = SecondWin(0),
                firstWin = FirstWin(0)
            )
        )
    }
}
