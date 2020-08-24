package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("Lotto 생성자 확인, input String ")
    @Test
    fun validateLottoInput() {
        assertThat(Lotto.from("1,2,3,4,5,6"))
            .isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("해당 로또에 보너스 번호 포함 여부")
    @Test
    fun checkBonusNumber() {
        val lotto = Lotto.from("1,2,3,4,5,6")
        val bonusNumber = LottoNumber.from(1)
        assertThat(lotto.isContainNumber(bonusNumber))
            .isEqualTo(true)
    }

    @DisplayName("Lotto 테스트, 갯수 확인")
    @Test
    fun validateLottoCount() {
        assertThatThrownBy { Lotto.from("1,2,3,4") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Lotto 테스트, 중복 및 갯수 확인")
    @Test
    fun validateLottoCountAndDuplication() {
        assertThatThrownBy { Lotto.from("1,2,3,4,5,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
