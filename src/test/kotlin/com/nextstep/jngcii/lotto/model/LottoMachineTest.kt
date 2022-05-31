package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `인자로 받은 갯수만큼 Lotto를 반환`() {
        val count = 6
        val lottos: List<Lotto> = LottoMachine.get(count)

        assertThat(lottos.size).isEqualTo(count)
    }
}
