package lotto.domain

import lotto.fixture.LottoNumberFixture
import org.assertj.core.api.Assertions
import org.assertj.core.api.ThrowableAssert
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `번호를 중복해서 여러개 선택할 수 없다`() {
        // when
        val throwingCallable =
            ThrowableAssert.ThrowingCallable { LottoNumbers.of(LottoNumberFixture.DUPLICATED_LOTTO_NUMBER_LIST) }

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy(throwingCallable)
            .withMessage("중복된 번호를 선택할 수 없습니다.")
    }

    @Test
    fun `6개보다 적거나 많은 숫자를 선택할 수 없다`() {
        // when
        val throwingCallable =
            ThrowableAssert.ThrowingCallable { LottoNumbers.of(LottoNumberFixture.LOTTO_NUMBER_LIST_OF_SEVEN) }

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy(throwingCallable)
            .withMessage("6개의 번호를 선택해야 합니다.")
    }
}
