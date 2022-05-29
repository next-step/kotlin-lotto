package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ValueSource(strings = ["-1", "0"])
    @ParameterizedTest
    fun `돈을 자연수가 아닌 수로 입력했을때 에러 발생시키는지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkIsValidMoney(input)
        }
    }

    @ValueSource(strings = ["-1", "0"])
    @ParameterizedTest
    fun `보너스볼 자연수가 아닌 수로 입력했을때 에러 발생시키는지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkValidBonusBall(input)
        }
    }

    @ValueSource(strings = ["1,2,3", "1", "1,2,3,4,5,6,7,8"])
    @ParameterizedTest
    fun `로또번호의 개수가 6개가 아닐때 에러인지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkValidLotto(input)
        }
    }

    @ValueSource(strings = ["1,2,3,4,5,100", "-1,2,3,4,5,6"])
    @ParameterizedTest
    fun `로또번호가 1~45가 아닐때 에러인지 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkValidLotto(input)
        }
    }

    @Test
    fun `max값 넘게 입력했을때 에러발생하는지 테스트`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkNaturalNumber("3", 1)
        }
    }
}
