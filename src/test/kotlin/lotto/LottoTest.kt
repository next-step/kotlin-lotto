package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName("Lotto 생성자 확인, input String ")
    @Test
    fun validateLottoString() {
        assertThat(Lotto("1,2,3,4,5,6"))
            .isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("Lotto 생성자 확인, input set ")
    @Test
    fun validateLottoSet() {
        assertThat(
            Lotto(
                setOf(
                    LottoNumber.newInstance(1),
                    LottoNumber.newInstance(2),
                    LottoNumber.newInstance(3),
                    LottoNumber.newInstance(4),
                    LottoNumber.newInstance(5),
                    LottoNumber.newInstance(6)
                )
            )
        ).isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("Lotto 생성자 확인, input empty ")
    @Test
    fun validateLottoEmpty() {
        assertThat(Lotto()).isNotInstanceOf(Exception::class.java)
    }

    @DisplayName("발생한 로또와 당첨번호가 일치하는 경우 받는 Prize")
    @Test
    fun checkGetPrize() {
        val lotto = Lotto("1,2,3,4,5,6")
        val prizeLotto = Lotto("1,2,3,4,5,6")
        assertThat(lotto.getPrize(prizeLotto))
            .isEqualTo(Prize.MATCH_ALL)
    }

    @DisplayName("해당 로또에 보너스 번호 포함 여부")
    @Test
    fun checkBonusNumber() {
        val lotto = Lotto("1,2,3,4,5,6")
        val bonusNumber = LottoNumber.newInstance(1)
        assertThat(lotto.isContainBonusNumber(bonusNumber))
            .isEqualTo(true)
    }
}
