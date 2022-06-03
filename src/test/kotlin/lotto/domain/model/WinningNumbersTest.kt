package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `WinningNumbers는 당첨 번호 목록을 보관한다`() {
        val numbers = setOf(
            LottoNumber[1],
            LottoNumber[2],
            LottoNumber[3],
            LottoNumber[4],
            LottoNumber[5],
            LottoNumber[6],
        )
        val winningNumbers = WinningNumbers(numbers, LottoNumber[7])

        assertThat(winningNumbers.numbers).isEqualTo(numbers)
    }

    @Test
    fun `WinningNumbers의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(listOf(1, 2, 3, 4, 5), LottoNumber[7])
        }
    }

    @Test
    fun `default를 통해 테스트 등에서 쓰일 기본 WinningNumbers 객체를 얻을 수 있다`() {
        val expected = WinningNumbers(
            setOf(
                LottoNumber[1],
                LottoNumber[2],
                LottoNumber[3],
                LottoNumber[4],
                LottoNumber[5],
                LottoNumber[6]
            ),
            LottoNumber[7]
        )

        assertThat(WinningNumbers.default()).isEqualTo(expected)
    }

    @Test
    fun `in 키워드를 통해 LottoNumber가 WinningNumbers에 포함되는지 확인할 수 있다`() {
        val winningNumbers = WinningNumbers.default()

        assertThat(LottoNumber[1] in winningNumbers).isEqualTo(true)
        assertThat(LottoNumber[8] in winningNumbers).isEqualTo(false)
    }

    @Test
    fun `WinningNumbers는 당첨 번호와 보너스볼 번호를 보관한다`() {
        val lotto = setOf(
            LottoNumber[1],
            LottoNumber[2],
            LottoNumber[3],
            LottoNumber[4],
            LottoNumber[5],
            LottoNumber[6]
        )
        val bonusBall = LottoNumber[7]
        val winningNumbers = WinningNumbers(lotto, bonusBall)

        assertThat(winningNumbers.numbers).isEqualTo(lotto)
        assertThat(winningNumbers.bonusBall).isEqualTo(bonusBall)
    }

    @Test
    fun `당첨 번호와 보너스볼 번호가 중복될 시 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val lotto = setOf(
                LottoNumber[1],
                LottoNumber[2],
                LottoNumber[3],
                LottoNumber[4],
                LottoNumber[5],
                LottoNumber[6]
            )
            val bonusBall = lotto.first()

            WinningNumbers(lotto, bonusBall)
        }
    }
}
