package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {

    @Test
    fun `lotto init throw exception when lottoNumber count is over 6`() {
        val lottoNumberCount = 7
        val lottoNumberList = (1..lottoNumberCount).map { LottoNumber(it) }

        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumberList)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage)
    }

    @Test
    fun `lotto init throw exception when lottoNumber count is 6 but lottoNumber is all the same`() {
        val lottoNumberCount = 6
        val lottoNumber = 2
        val lottoNumberList = (1..lottoNumberCount).map {
            LottoNumber(lottoNumber)
        }

        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumberList)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage)
    }

    @Test
    fun getMatchCountTest() {
        val sameCount = 3
        val numbers = "1,2,3,4,5,6"
        val lotto = LottoGenerator.generateLotto(numbers)

        val otherNumbers = "1,2,3,7,8,9"
        val otherLotto = LottoGenerator.generateLotto(otherNumbers)

        val count = lotto.getMatchCount(otherLotto)

        assertThat(count).isEqualTo(sameCount)
    }
}
