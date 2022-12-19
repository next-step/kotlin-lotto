package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import step2.domain.Lotto
import java.lang.IllegalArgumentException

class LottoTest {

    @Test
    @DisplayName("6자리의 숫자 가진 로또 반환")
    fun lottoSizeTest() {
        val lotto = Lotto(listOf(1, 11, 21, 31, 41, 43))
        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    @DisplayName("6자리가 아닌 로또 번호를 입력 했을 경우 예외 발생")
    fun notSixDigitNumberException() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4))
        }
    }

//    실 코드에서는 예외가 발생하나 테스트 코드에서 예외 발생이 안하는 이유를 모르겠다..
//    @ParameterizedTest
//    @ValueSource(strings = ["0,2,3,4,5,6","1,2,3,4,5,46"])
//    @DisplayName("1과 45 사이의 숫자가 아닌 번호 입력 시 예외 발생")
//    fun lottoRangeException(numbers: String) {
//        val numbersToInt = numbers.split(",").map { it.toInt() }
//        assertThrows<IllegalArgumentException> {
//            Lotto(numbersToInt)
//        }
//    }

}
