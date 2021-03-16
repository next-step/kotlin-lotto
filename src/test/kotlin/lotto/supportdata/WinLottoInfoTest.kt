package lotto.supportdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class WinLottoInfoTest {

    @Test
    @DisplayName("입력으로 받은 당첨번호를 파싱하여 LottoTicket 으로 만든다.")
    fun makeWinLottoTicket() {
        val winLottoTicket = WinLottoInfo("1, 2, 3, 4, 5, 6", 7).winLottoTicket
        assertThat(winLottoTicket).isNotNull
    }

    @Test
    @DisplayName("입력값에서 , 다음에 값이 없으면 제외되며 개수 부족으로 winLottoTicket 만들기를 실패한다")
    fun failToMakeWinLottoTicket() {
        assertThrows<IllegalArgumentException>("입력된 로또 숫자 개수가 올바르지 않습니다 : 5 개 입력함") {
            WinLottoInfo("1, 2, 3, 4, 5,", 7).winLottoTicket
        }
    }

    @Test
    @DisplayName("입력으로 받은 당첨번호 숫자는 보너스 숫자와 겹칠 수 없다")
    fun bonusNumberValidate() {
        assertThrows<IllegalArgumentException> {
            WinLottoInfo("1, 2, 3, 4, 5, 6", 6)
        }
    }
}
