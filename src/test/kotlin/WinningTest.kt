import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningTest {

    @Test
    fun `다섯개의 번호가 맞을때 보너스 번호도 일치하면 2등이 된다`() {
        Assertions.assertThat(Winning.matchWinning(5, true)).isEqualTo(Winning.SECOND)
    }

    @Test
    fun `다섯개의 번호가 맞을때 보너스 번호가 다르면 3등이 된다`() {
        Assertions.assertThat(Winning.matchWinning(5, false)).isEqualTo(Winning.THIRD)
    }
}
