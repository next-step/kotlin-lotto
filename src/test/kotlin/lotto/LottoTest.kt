package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("Lotto 테스트, 갯수 확인")
    @Test
    fun validateLottoCount() {
        assertThatThrownBy { Lotto("1,2,3,4,5,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("Lotto 테스트, String 확인 ")
    @Test
    fun validateLottoString() {
        assertThat(Lotto("1,2,3,4,5,6"))
            .isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("Lotto 테스트, set 확인")
    @Test
    fun validateLottoSet() {
        assertThat(
            Lotto(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        ).isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("Lotto 테스트, set 확인")
    @Test
    fun validateLottoEmpty() {
        assertThat(Lotto()).isNotInstanceOf(Exception::class.java)
    }
}
