package lottogame.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class GameMoneyTest {

    @Test
    fun `최소 게임 머니는 천원이다`() {
        shouldThrow<IllegalArgumentException> { GameMoney.from(999) }
    }

    @Test
    fun `게임 머니는 천원 단위로 입력해야 한다`() {
        shouldThrow<IllegalArgumentException> { GameMoney.from(1001) }
    }
}
