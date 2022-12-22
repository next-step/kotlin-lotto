package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RandomLottoTicketGeneratorTest {
    @Test
    fun `임의의 6개 숫자를 중복없이 생성한다`() {
        val testTicket = RandomLottoTicketGenerator()
        Assertions.assertThat(testTicket.lottoNumbers.toSet().size).isSameAs(LOTTO_NUMBER_SIZE)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
