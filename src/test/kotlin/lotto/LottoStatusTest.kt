package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoStatusTest : FunSpec({
    test("현재 당첨 상태인지 구할 수 있다.") {
        LottoStatus.WIN.isWinStatus() shouldBe true
        LottoStatus.NOT_WIN.isWinStatus() shouldBe false
        LottoStatus.WAITING.isWinStatus() shouldBe false
    }

    test("맞춘 갯수로 당첨 여부를 구할 수 있다.") {
        LottoStatus.from(matchCount = 3) shouldBe LottoStatus.WIN
        LottoStatus.from(matchCount = 2) shouldBe LottoStatus.NOT_WIN
    }
})
