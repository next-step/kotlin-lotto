package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "WinLotto와 Lotto의 번호가 6개 일치하는 경우, getCountOfMatch()가 6을 반환한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }.toHashSet())
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        winLotto.getCountOfMatch(lotto) shouldBe 6
    }

    "WinLotto와 Lotto의 번호가 3개 일치하는 경우, getCountOfMatch()가 3을 반환한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }.toHashSet())
        val winLotto = WinLotto.create(listOf(1, 2, 3, 7, 8, 9), 45)
        winLotto.getCountOfMatch(lotto) shouldBe 3
    }

    "WinLotto와 Lotto의 번호가 0개 일치하는 경우, getCountOfMatch()가 0을 반환한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { number -> LottoNumber(number) }.toHashSet())
        val winLotto = WinLotto.create(listOf(7, 8, 9, 10, 11, 12), 45)
        winLotto.getCountOfMatch(lotto) shouldBe 0
    }

    "WinLotto와 Lotto의 번호가 보너스 번호가 일치하는 경우, isBonusNumberIn()가 true를 반환한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7).map { number -> LottoNumber(number) }.toHashSet())
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 7)
        winLotto.isBonusNumberIn(lotto) shouldBe true
    }

    "WinLotto와 Lotto의 번호가 보너스 번호가 일치하지 않는 경우, isBonusNumberIn()가 false를 반환한다." {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7).map { number -> LottoNumber(number) }.toHashSet())
        val winLotto = WinLotto.create(listOf(1, 2, 3, 4, 5, 6), 9)
        winLotto.isBonusNumberIn(lotto) shouldBe false
    }
})
