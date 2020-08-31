package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberOfManualLottoTest {
    @DisplayName("수동으로 구매할 로또 갯수, 에러")
    @ParameterizedTest
    @ValueSource(strings = ["-1000", "500", "ss", "%"])
    fun validateManualLottoCountInput(manualLottoCount: String) {
        val gameMoney = LottoGameMoney.from("1000")!!
        assertThat(NumberOfManualLotto.of(manualLottoCount, gameMoney))
            .isNull()
    }

    @DisplayName("수동으로 구매할 로또 갯수")
    @Test
    fun validateManualLottoCountInput() {
        val gameMoney = LottoGameMoney.from("3000")!!
        assertAll(
            { assertThat(NumberOfManualLotto.of("1", gameMoney)).isInstanceOfAny(NumberOfManualLotto::class.java) },
            { assertThat(NumberOfManualLotto.of("2", gameMoney)).isInstanceOfAny(NumberOfManualLotto::class.java) },
            { assertThat(NumberOfManualLotto.of("3", gameMoney)).isInstanceOfAny(NumberOfManualLotto::class.java) },
            { assertThat(NumberOfManualLotto.of("4", gameMoney)).isNull() }
        )
    }
}
