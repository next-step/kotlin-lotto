package lotto.domain

import lotto.fixture.LottoNumberFixture
import lotto.fixture.LottoNumbersFixture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.ThrowableAssert
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `번호를 중복해서 여러개 선택할 수 없다`() {
        // when
        val throwingCallable =
            ThrowableAssert.ThrowingCallable { LottoNumbers.of(LottoNumberFixture.DUPLICATED_LOTTO_NUMBER_LIST) }

        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy(throwingCallable)
            .withMessage("중복된 번호를 선택할 수 없습니다.")
    }

    @Test
    fun `6개보다 적거나 많은 숫자를 선택할 수 없다`() {
        // when
        val throwingCallable =
            ThrowableAssert.ThrowingCallable { LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_OF_SEVEN) }

        // then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy(throwingCallable)
            .withMessage("6개의 번호를 선택해야 합니다.")
    }

    @Test
    fun `특정 로또 번호를 포함하고 있는지 확인할 수 있다`() {
        // given
        val lottoNumbers = LottoNumbersFixture.LOTTO_NUMBER_SET_FIRST

        // then
        assertAll(
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.ONE)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.FIVE)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.SEVEN)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.TEN)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.TWENTY_THREE)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.THIRTY)).isTrue },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.FORTY_FOUR)).isFalse },
            { assertThat(lottoNumbers.isContainLottoNumber(LottoNumberFixture.FORTY_FIVE)).isFalse }
        )
    }
}
