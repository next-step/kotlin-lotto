import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `Lotto 객체 생성 시 번호 개수가 6개가 아니면 예외를 발생시킨다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3)))
        }
        assertThat(exception.message).isEqualTo("로또 번호는 6개여야 합니다.")
    }

    @Test
    fun `Lotto 객체 생성 시 번호 개수가 정확하면 정상 생성된다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            ),
        )
        assertThat(lotto).isNotNull
    }

    @Test
    fun `match 메서드는 일치하는 번호 개수에 따라 적절한 LottoRank를 반환한다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            ),
        )

        val winningNumbers = WinningLotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            ),
            bonusNumber = LottoNumber(45),
        )

        val result = lotto.match(winningNumbers)

        assertThat(result).isEqualTo(LottoRank.FIRST)
    }
}
