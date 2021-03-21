package lotto.supportdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoParserKtTest {

    @Test
    @DisplayName("문자열을 파싱하여 로또 티켓으로 만든다")
    fun parseInputToLottoTestTest() {
        val lottoTicket = parseInputToLotto("1,2,3,4,5,6")
        assertThat(lottoTicket).isNotNull
    }
}
