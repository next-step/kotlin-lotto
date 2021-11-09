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
    @DisplayName("로또 랜덤번호가 잘 생성된 경우")
    fun `correct lotto list format`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(1), LottoNumber(13), LottoNumber(23), LottoNumber(33), LottoNumber(43))

        // when
        val list = Lotto(lottoList)

        // then
        assertThat(list.numbers.size).isEqualTo(6)
        assertThat(list.numbers.map { it.number }).isEqualTo(listOf(1, 10, 13, 23, 33, 43))
    }

    @Test
    @DisplayName("로또 형식이 맞지 않는 경우")
    fun `check lotto list format`() {
        // given
        val lottoList = listOf(LottoNumber(21), LottoNumber(32), LottoNumber(1), LottoNumber(13), LottoNumber(23), LottoNumber(33), LottoNumber(43))

        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(lottoList) }
            .withMessage(EXCEPTION_LOTTO_FORMAT)
    }

    @Test
    @DisplayName("로또 중복된 숫자가 있는 경우")
    fun `check duplicated lotto item`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(10), LottoNumber(10), LottoNumber(13), LottoNumber(23), LottoNumber(33))

        // when & then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(lottoList) }
            .withMessage(EXCEPTION_DUPLICATED_LOTTO_NUMBER)
    }

    @Test
    @DisplayName("로또 숫자에 특정 번호가 있는 경우")
    fun `check existence of input number on lotto numbers`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(1), LottoNumber(45), LottoNumber(13), LottoNumber(23), LottoNumber(33))

        // when
        val hasNumber = Lotto(lottoList).hasNumber(LottoNumber(10))

        // then
        assertThat(hasNumber).isEqualTo(true)
    }

    @Test
    @DisplayName("로또 숫자에 특정 번호가 없 경우")
    fun `check nonexistence of input number on lotto numbers`() {
        // given
        val lottoList = listOf(LottoNumber(10), LottoNumber(45), LottoNumber(3), LottoNumber(13), LottoNumber(23), LottoNumber(33))

        // when
        val hasNumber = Lotto(lottoList).hasNumber(LottoNumber(44))

        // then
        assertThat(hasNumber).isEqualTo(false)
    }

    @Test
    @DisplayName("지난주 당첨 번호 파싱하는 로직 확인")
    fun `check parsing logic of last win numbers`() {
        // given
        val input = "1,2,3,4,5,6"
        val expected = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        // when
        val lottoNumber = Lotto.parsingTextToLotto(input)

        // then
        assertThat(lottoNumber).isEqualTo(expected)
    }
}
