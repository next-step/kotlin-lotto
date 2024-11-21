package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoGamesTest : StringSpec({
    "입력받은 로또 게임의 수가 0이면 예외 처리한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> { LottoGames(listOf()) }
        exception.message shouldBe "1개 이상의 로또 게임을 가지고 있어야 합니다."
    }
})
