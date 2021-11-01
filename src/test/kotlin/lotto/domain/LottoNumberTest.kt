package lotto.domain

import lotto.exception.InvalidLottoNumberException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("한개의 로또 번호 테스트")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    @DisplayName("1 ~ 45 범위가 아닌 번호가 입력될 경우 예외 발생")
    fun `sut throw when lotto number doesn't fit the range`(number: Int) {
        // Act, Assert
        assertThrows<InvalidLottoNumberException> { LottoNumber(number) }
    }
}
