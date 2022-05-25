package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.WinningLotto.Companion.winningLottoOf
import lotto.domain.enums.LottoRank
import lotto.exception.DuplicateLottoNumberException

class WinningLottoTest : FunSpec({

    test("로또 보너스 숫자는 로또 숫자와 중복될 수 없습니다.") {
        val lottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        shouldThrow<DuplicateLottoNumberException> {
            winningLottoOf(lottoNumbers).bonus(LottoNumber(1))
        }

        shouldThrow<DuplicateLottoNumberException> {
            winningLottoOf(1, 2, 3, 4, 5, 6).bonus(1)
        }
    }

    test("로또 숫자 6개가 일치할 때, 1등으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 3, 4, 5, 6)) shouldBe LottoRank.FIRST
    }

    test("로또 숫자 5개가 일치하고, 보너스 번호가 일치할 때, 2등으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 3, 4, 5, 45)) shouldBe LottoRank.SECOND
    }

    test("로또 숫자 5개가 일치할 때, 3등으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 3, 4, 5, 16)) shouldBe LottoRank.THIRD
    }

    test("로또 숫자 4개가 일치할 때, 4등으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 3, 4, 15, 16)) shouldBe LottoRank.FOURTH
    }

    test("로또 숫자 3개가 일치할 때, 5등으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 3, 14, 15, 16)) shouldBe LottoRank.FIFTH
    }

    test("로또 숫자 2개 이하일때, 꽝(NONE)으로 매칭된다.") {
        val winningLotto = winningLottoOf(1, 2, 3, 4, 5, 6).bonus(45)
        winningLotto.match(Lotto(1, 2, 13, 14, 15, 16)) shouldBe LottoRank.NONE
        winningLotto.match(Lotto(1, 12, 13, 14, 15, 16)) shouldBe LottoRank.NONE
        winningLotto.match(Lotto(11, 12, 13, 14, 15, 16)) shouldBe LottoRank.NONE
    }
})
