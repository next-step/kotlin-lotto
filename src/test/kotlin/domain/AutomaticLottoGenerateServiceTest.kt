package domain

import domain.lotto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import service.AutomaticLottoGenerateService

class AutomaticLottoGenerateServiceTest {
    private val automaticLottoGenerateService = AutomaticLottoGenerateService()

    @Test
    fun generateAutomaticLotto() {
        // given

        // when
        val automaticLotto = automaticLottoGenerateService.generateAutomaticLotto()

        // then
        assertThat(automaticLotto).isNotNull
        assertThat(automaticLotto.numbers).hasSize(6)
        assertThat(automaticLotto.numbers.filter { it.number > LottoNumber.MAX_NUMBER || it.number < LottoNumber.MIN_NUMBER }).hasSize(
            0,
        )
    }
}
