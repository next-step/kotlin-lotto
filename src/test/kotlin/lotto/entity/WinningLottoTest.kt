package lotto.entity

import lotto.domain.entity.winning.WinningLotto
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2", "1,11,22,33,35,37,41,42"])
    fun `생성된 지난주 로또 번호가(6개)가 아닐 경우 IllegalArgumentException 예외가 발생한다`(winningLottoNumber: String) {
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                winningLottoNumber
                    .split(",")
                    .map { it.trim().toInt() }
                    .sorted()
                    .toList()
            )
        }
    }
}
