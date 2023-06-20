package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "두 Lotto의 번호가 6개 일치하는 경우, getCountOfMatch()가 6을 반환한다." {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        lotto1.getCountOfMatch(lotto2) shouldBe 6
    }

    "두 Lotto의 번호가 3개 일치하는 경우, getCountOfMatch()가 3을 반환한다." {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 44, 55, 66))
        lotto1.getCountOfMatch(lotto2) shouldBe 3
    }

    "두 Lotto의 번호가 0개 일치하는 경우, getCountOfMatch()가 0을 반환한다." {
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(11, 22, 33, 44, 55, 66))
        lotto1.getCountOfMatch(lotto2) shouldBe 0
    }
})
