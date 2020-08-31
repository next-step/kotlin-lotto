package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ManualLottoCountTest {
    @DisplayName("수동으로 구매할 로또 갯수, 에러")
    @ParameterizedTest
    @ValueSource(strings = ["-1000", "500", "ss", "%"])
    fun validateManualLottoCountInput(manualLottoCount: String) {
        val gameMoney = LottoGameMoney.from("1000")!!
        assertThat(ManualLottoCount.of(manualLottoCount, gameMoney))
            .isNull()
    }

    @DisplayName("수동으로 구매할 로또 갯수")
    @Test
    fun validateManualLottoCountInput() {
        val gameMoney = LottoGameMoney.from("3000")!!
        assertAll(
            { assertThat(ManualLottoCount.of("1", gameMoney)).isInstanceOfAny(ManualLottoCount::class.java) },
            { assertThat(ManualLottoCount.of("2", gameMoney)).isInstanceOfAny(ManualLottoCount::class.java) },
            { assertThat(ManualLottoCount.of("3", gameMoney)).isInstanceOfAny(ManualLottoCount::class.java) },
            { assertThat(ManualLottoCount.of("4", gameMoney)).isNull() }
        )
    }
}
