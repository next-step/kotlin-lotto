package lotto

import lotto.domain.LottoMatch
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoStatistics
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStatisticsTest {

    @Test
    fun `1) 당첨번호를 5개, 7개를 입력한 경우 예외 발생`() {
        val lottoNumber = listOf(
            LottoNumbers(
                listOf(
                    LottoNumber.from(3),
                    LottoNumber.from(20),
                    LottoNumber.from(4),
                    LottoNumber.from(15),
                    LottoNumber.from(44),
                    LottoNumber.from(45)
                )
            )
        )
        val erroredLottoNumberFive = listOf(
            LottoNumber.from(3),
            LottoNumber.from(20),
            LottoNumber.from(4),
            LottoNumber.from(15),
            LottoNumber.from(45)
        )
        val erroredLottoNumberSeven = listOf(
            LottoNumber.from(3),
            LottoNumber.from(20),
            LottoNumber.from(4),
            LottoNumber.from(15),
            LottoNumber.from(38),
            LottoNumber.from(44),
            LottoNumber.from(45)
        )

        val lottoBonusNumber = LottoNumber.from(31)

        assertThrows<IllegalArgumentException> { LottoStatistics(1000, lottoNumber, LottoNumbers(erroredLottoNumberFive), lottoBonusNumber) }
        assertThrows<IllegalArgumentException> { LottoStatistics(1000, lottoNumber, LottoNumbers(erroredLottoNumberSeven), lottoBonusNumber) }
    }

    @Test
    fun `2) 수익률 계산하기(1,000원으로 5등 당첨인 경우 5,000원을 보상받기 때문에 5배`() {
        val lottoNumber = listOf(
            LottoNumbers(
                listOf(
                    LottoNumber.from(3),
                    LottoNumber.from(20),
                    LottoNumber.from(4),
                    LottoNumber.from(15),
                    LottoNumber.from(11),
                    LottoNumber.from(31)
                )
            )
        )
        val prizedFive = listOf(
            LottoNumber.from(3),
            LottoNumber.from(20),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(2),
            LottoNumber.from(34)
        )
        val lottoBonusNumber = LottoNumber.from(31)

        Assertions.assertThat(LottoStatistics(1000, lottoNumber, LottoNumbers(prizedFive), lottoBonusNumber).earningRate).isEqualTo(5.0)
    }

    @Test
    fun `3) 카운트별 일치하는 로또 개수 계산하기`() {
        val lottoNumber = listOf(
            LottoNumbers(
                listOf(
                    LottoNumber.from(3),
                    LottoNumber.from(20),
                    LottoNumber.from(1),
                    LottoNumber.from(15),
                    LottoNumber.from(11),
                    LottoNumber.from(31)
                )
            )
        )
        val prizedFive = listOf(
            LottoNumber.from(3),
            LottoNumber.from(20),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(2),
            LottoNumber.from(31)
        )

        val lottoBonusNumber = LottoNumber.from(32)

        Assertions.assertThat(LottoStatistics(1000, lottoNumber, LottoNumbers(prizedFive), lottoBonusNumber).resultMap[LottoMatch.FIFTH]).isEqualTo(1)
    }
}
