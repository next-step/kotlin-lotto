package lotto.ticket

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.RepetitionInfo

internal class LottoNumberTest {

    @RepeatedTest(45)
    fun `로또 넘버 박스는 1~45까지의 범위를 갖는다`(repetitionInfo: RepetitionInfo) {
        val index = repetitionInfo.currentRepetition
        assertThat(LottoNumber.LOTTO_NUMBER_BOX[index]).isEqualTo(LottoNumber(index))
    }
}
