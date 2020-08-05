package lotto.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinnerLottoTest {
    @DisplayName(value = "보너스 숫자가 기존 로또 번호와 중복되는 숫자인지 확인한다.")
    @Test
    fun validLottoCheck() {
        assertThatThrownBy {
            WinnerLotto(
                Lotto(listOf(LottoNo("1"), LottoNo("2"), LottoNo("3"), LottoNo("4"), LottoNo("5"), LottoNo("10"))), LottoNo("1")
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
