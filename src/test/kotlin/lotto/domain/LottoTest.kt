package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {

    @Test
    fun `lotto init throw exception when lottoNumber count is over 6`() {
        val lottoNumberCount = 7
        val lottoNumberList = (1..lottoNumberCount).map { LottoNumber(it) }.toMutableSet()

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
        }.toMutableSet()

        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumberList)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage)
    }

    @Test
    fun getMatchCountTest() {
        val sameCount = 3
        val numbers = "1,2,3,4,5,6"
        val lotto = LottoCustomGenerator.generateLotto(numbers)

        val otherNumbers = "1,2,3,7,8,9"
        val otherLotto = LottoCustomGenerator.generateLotto(otherNumbers)

        val count = lotto.getMatchCount(otherLotto)

        assertThat(count).isEqualTo(sameCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6", "3,5,6,9,12,33", "1,2,44,5,6,3"])
    fun `containLottoNumber should be true when Lotto has lottoNumber`(lottoNumbers: String) {
        val number = 3
        val lottoNumber = LottoNumber(number)
        val lotto = LottoCustomGenerator.generateLotto(lottoNumbers)

        val result = lotto.containLottoNumber(lottoNumber)

        assertThat(result).isTrue
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,4,5,6,9", "5,6,9,12,33, 42", "1,2,44,5,6,9"])
    fun `containLottoNumber should be false when Lotto does not have lottoNumber`(lottoNumbers: String) {
        val number = 3
        val lottoNumber = LottoNumber(number)
        val lotto = LottoCustomGenerator.generateLotto(lottoNumbers)

        val result = lotto.containLottoNumber(lottoNumber)

        assertThat(result).isFalse
    }
}
