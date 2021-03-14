package lotto.domain.result

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoResultTest {
    @DisplayName("로또 결과 리스트를 받아서 ")
    @Test
    fun name() {
        listOf(LottoRank.FIRST, LottoRank.SECOND, LottoRank.NONE)
    }
}