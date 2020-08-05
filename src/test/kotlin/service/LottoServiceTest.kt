package service

import model.DiceRandomMaker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    @DisplayName("로또를 생성하고 로또 목록에 포함시킨다")
    fun `createLotto`() {
        val lottoService = LottoService()
        val count = 3
        repeat(3) {
            lottoService.create(DiceRandomMaker())
        }
        assertThat(lottoService.lottoList.size).isEqualTo(count)
    }
}
