package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FunSpec({
    test("로또 게임은 N개의 로또를 가진다.") {
        val lottoList = listOf(
            Lotto(numbers = setOf(1, 20, 30, 27, 15, 36)),
            Lotto(numbers = setOf(10, 20, 30, 40, 25, 16)),
            Lotto(numbers = setOf(11, 12, 13, 14, 15, 16))
        )

        LottoGame(lottoList).lottoList.size shouldBe 3
    }
})
