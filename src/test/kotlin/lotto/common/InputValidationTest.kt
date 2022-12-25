package lotto.common

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputValidationTest {
    private val inputValidation = InputValidation()

    @DisplayName("구입금액에 null값이 들어오면 에러를 낸다")
    @ParameterizedTest
    @NullAndEmptySource
    fun amountIsNotAllowedNull(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.amountValidate(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("구입금액에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun amountIsNotAllowedEmpty(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.amountValidate(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("구입금액에 숫자가 아니면 에러를 낸다")
    @ValueSource(strings = ["test", "!123", "zz1+"])
    fun amountIsNotMatchNumeric(input: String) {
        Assertions.assertThatThrownBy {
            inputValidation.amountValidate(input)
        }.isInstanceOf(ExceptionCode.NotMatchNumeric::class.java)
    }

    @ParameterizedTest
    @DisplayName("구입금액에 숫자 string가 들어오면 int로 바꿔준다")
    @ValueSource(strings = ["123", "11", "33"])
    fun amountStringToDigit(input: String) {
        Assertions.assertThat(inputValidation.amountValidate(input)).isEqualTo(input.toInt())
    }

    @DisplayName("당첨번호에 null값이 들어오면 에러를 낸다")
    @ParameterizedTest
    @NullAndEmptySource
    fun winLotteryIsNotAllowedNull(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.winLotteryValidation(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("당첨번호에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun winLotteryIsNotAllowedEmpty(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.winLotteryValidation(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("당첨번호에 , 구분자가 없으면 에러를 낸다")
    @ValueSource(strings = ["1;2;3;4", "123451234", "1234512345"])
    fun winLotteryIsNotFindSeparator(input: String) {
        Assertions.assertThatThrownBy {
            inputValidation.winLotteryValidation(input)
        }.isInstanceOf(ExceptionCode.NotFindSeparator::class.java)
    }

    @ParameterizedTest
    @DisplayName("당첨번호가 6자리가 아니면 에러를 낸다")
    @ValueSource(strings = ["1,2,3,4", "5,6,7,8", "10,11"])
    fun winLotteryIsNotSixNum(input: String) {
        Assertions.assertThatThrownBy {
            inputValidation.winLotteryValidation(input)
        }.isInstanceOf(ExceptionCode.NotWinLotteryCount::class.java)
    }

    @ParameterizedTest
    @DisplayName("당첨번호가 , 구분자로 split한다")
    @ValueSource(strings = ["1,2,3,4,5,6", "5,6,7,8,9,10"])
    fun winLotteryStringToDigit(input: String) {
        Assertions.assertThat(inputValidation.winLotteryValidation(input)).isEqualTo(input.split(",").map { it.toInt() })
    }
}
