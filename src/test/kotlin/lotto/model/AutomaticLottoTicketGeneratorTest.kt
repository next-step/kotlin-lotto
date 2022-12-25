package lotto.model

import lotto.LottoAllTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class AutomaticLottoTicketGeneratorTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = AutomaticLottoTicketGenerator(1)
        Assertions.assertThat(testTicket.lottoNumbers[0].values.toSet().size).isSameAs(LottoAllTest.LOTTO_NUMBER_SIZE)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
