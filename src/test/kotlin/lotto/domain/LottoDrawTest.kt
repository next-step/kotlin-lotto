package lotto.domain

import lotto.domain.dto.LottoNumber
import lotto.model.Rank
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoDrawTest {
    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        val drawNumber = input.replace(" ", "").split(",").map { it.toInt() }
        val bonus = bonusNumber.toInt()
        val draw = LottoDraw(drawNumber, bonus)
        draw.draw(lottoList)

        Assertions.assertThat(draw.winningRanks.count { it == Rank.FIRST }).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5, 6:7"], delimiter = ':')
    internal fun `2등 당첨 테스트`(input: String, bonusNumber: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 7)))
        val drawNumber = input.replace(" ", "").split(",").map { it.toInt() }
        val bonus = bonusNumber.toInt()
        val draw = LottoDraw(drawNumber, bonus)
        draw.draw(lottoList)

        Assertions.assertThat(draw.winningRanks.count { it == Rank.SECOND }).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1, 2, 3, 4, 5, -6:11", "2, 3, 4, 5, 66:11", "5, -1, 6, 7, 8, 9:11", "1,2,3,4,5,6:66", "1,2,3,4,5,6:5"],
        delimiter = ':'
    )
    fun `당첨번호 에러 처리 테스트`(input: String, bonusNumber: String) {
        val drawNumber = input.replace(" ", "").split(",").map { it.toInt() }
        val bonus = bonusNumber.toInt()
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { LottoDraw(drawNumber, bonus) }
    }
}
