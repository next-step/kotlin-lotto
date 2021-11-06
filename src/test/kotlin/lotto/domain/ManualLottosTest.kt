package lotto.domain

import lotto.exception.IllegalLottosException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ManualLottosTest {
    @DisplayName("수동로또로 구매한 수량은 구매가능수량보다 작아야 한다.")
    @Test
    fun tooManyManuals() {
        val manualLottos = Fixture.manualLottos.lottos
        assertThatExceptionOfType(IllegalLottosException::class.java)
            .isThrownBy { ManualLottos(manualLottos, manualLottos.size - 1) }
    }

    @DisplayName("수동로또로 자동로또를 생성할 수 있어야 한다.")
    @Test
    fun generateAutoLottos() {
        val manualLottos = Fixture.manualLottos.lottos
        val quantity = manualLottos.size + 2
        val autoLottos = ManualLottos(manualLottos, quantity)
            .generateAutoLottos(Fixture.generatorFactory)
        assertThat(autoLottos.lottos)
            .isEqualTo(listOf(Fixture.createLotto(), Fixture.createLotto()))
    }
}
