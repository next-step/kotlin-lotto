package lotto

import org.junit.jupiter.api.Test

internal class LottoResultTest {

    @Test
    fun `로또 확인을 위해 지난 주 당첨 번호, Lotto 정보를 전달 받는다`() {
        LottoResult("1, 2, 3, 4, 5, 6", Lotto(setOf()))
    }

    @Test
    fun `당첨된 숫자의 갯수를 확인한다`() {
//        assertThat(
//            Confirmation("1, 2, 3, 4, 5, 6", Lotto(setOf(1, 2, 3, 10, 11, 12))).winningNumbers.size
//        ).isEqualTo(3)
    }
}
