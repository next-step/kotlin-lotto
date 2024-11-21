import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6:45:FIRST",
        "1,2,3,4,5,7:6:SECOND",
        "1,2,3,4,5,7:45:THIRD",
        "1,2,3,4,8,9:45:FOURTH",
        "1,2,3,10,11,12:45:FIFTH",
        "7,8,9,10,11,12:45:NONE",
        delimiter = ':',
    )
    fun `match 메서드는 일치하는 번호 개수에 따라 적절한 LottoRank를 반환한다`(
        winningNumbers: String,
        bonusNumber: Int,
        expectedRank: LottoRank,
    ) {
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

        val winningLotto = WinningLotto(
            winningNumbers.split(",").map { LottoNumber(it.toInt()) },
            bonusNumber = LottoNumber(bonusNumber),
        )

        assertThat(lotto.match(winningLotto)).isEqualTo(expectedRank)
    }
}
