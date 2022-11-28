package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(strings = ["1;2;3", "a,v,c"])
    fun `generateLotto throw number format incorrect`(winningLottoNumbers: String) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoCustomGenerator.generateLotto(winningLottoNumbers)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_INPUT_FORMAT_EXCEPTION.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,6,7", "1,2,3,4,5", "1,1,1,1,1,1", ""])
    fun `generateLotto throw numbers counts not 6`(winningLottoNumbers: String) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoCustomGenerator.generateLotto(winningLottoNumbers)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBERS_COUNT_EXCEPTION.errorMessage)
    }

    @Test
    fun generateLotto() {
        val lottoNumberCount = 6
        val lottoNumber = "1,2,3,4,5,6"

        val lottoNumbers = (1..lottoNumberCount).map {
            LottoNumber(it)
        }.toMutableSet()

        val lotto = Lotto(lottoNumbers)

        val resultLotto = LottoCustomGenerator.generateLotto(lottoNumber)

        assertThat(lotto).isEqualTo(resultLotto)
        assertThat(resultLotto.numbers.count()).isEqualTo(6)
    }

    @Test
    fun `generateLottoFromNumbers로 로또를 생성하면, possibleNumbers 리스트로 된 로또가 생성된다`() {
        val lottoCount = 6
        val possibleNumbers = (1..lottoCount).map { LottoNumber(it) }
        val lottoGenerator: LottoGenerator = LottoManualGenerator()
        val resultLotto = lottoGenerator.generateLottoFromNumbers(possibleNumbers)

        assertThat(resultLotto.numbers.count()).isEqualTo(lottoCount)
        assertThat(resultLotto.numbers.toList()).isEqualTo(possibleNumbers)
    }
}
