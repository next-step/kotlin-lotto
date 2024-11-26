package lotto

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({

    "번호가 3개 일치하는 경우 5등이다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 3, 7, 8, 9))
        val actual = sut.match(lotto)

        actual shouldBe Reward.FIFTH
    }

    "번호가 4개 일치하는 경우 4등이다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 3, 4, 7, 8))
        val actual = sut.match(lotto)

        actual shouldBe Reward.FOURTH
    }

    "번호가 5개 일치하는 경우 3등이다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 3, 4, 5, 8))
        val actual = sut.match(lotto)

        actual shouldBe Reward.THIRD
    }

    "번호 5개와 보너스 볼이 일치하는 경우 2등이다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 3, 4, 5, 7))
        val actual = sut.match(lotto)

        actual shouldBe Reward.SECOND
    }

    "번호가 6개 모두 일치하는 경우 1등이다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 3, 4, 5, 6))
        val actual = sut.match(lotto)

        actual shouldBe Reward.FIRST
    }

    "번호가 3개 미만으로 일치하는 경우 보상은 존재하지 않는다." {
        val sut = WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(7)))

        val lotto = Lotto.manual(listOf(1, 2, 7, 8, 9, 10))
        val actual = sut.match(lotto)

        actual shouldBe Reward.NONE
    }

    "보너스 볼 번호가 당첨 번호 번호와 중복된다면 예외를 던진다." {
        shouldThrowWithMessage<IllegalArgumentException>("보너스 볼 번호는 당첨 번호와 중복될 수 없습니다.") {
            WinningLotto(Lotto.manual(listOf(1, 2, 3, 4, 5, 6)), BonusNumber(LottoNumber(6)))
        }
    }
})
