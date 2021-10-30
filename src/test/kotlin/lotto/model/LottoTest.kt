package lotto.model

import lotto.model.Lotto.Companion.EXCEPTION_DUPLICATED_LOTTO_NUMBER
import lotto.model.Lotto.Companion.EXCEPTION_LOTTO_FORMAT
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Lotto data class test
 * */
class LottoTest {
    @Test
    @DisplayName("로또 리스트가 옳바른 경우")
    fun `correct lotto list format`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(1), LottoNumber(13), LottoNumber(23), LottoNumber(33), LottoNumber(43))

        // when
        val list = Lotto(lottoList)

        // then
        assertThat(list.numbers.size).isEqualTo(6)
    }

    @Test
    @DisplayName("로또 리스트의 사이즈가 맞지 않는 경우")
    fun `check lotto list format`() {
        // given
        val lottoList = listOf(LottoNumber(21), LottoNumber(32), LottoNumber(1), LottoNumber(13), LottoNumber(23), LottoNumber(33), LottoNumber(43))

        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(lottoList) }
            .withMessage(EXCEPTION_LOTTO_FORMAT)
    }

    @Test
    @DisplayName("로또 리스트의 중복된 숫자가 있는 경우")
    fun `check duplicated lotto item`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(10), LottoNumber(10), LottoNumber(13), LottoNumber(23), LottoNumber(33))

        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(lottoList) }
            .withMessage(EXCEPTION_DUPLICATED_LOTTO_NUMBER)
    }
}
