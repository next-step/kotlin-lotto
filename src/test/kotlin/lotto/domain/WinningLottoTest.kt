package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoRank
import lotto.exception.DuplicateLottoNumberException

class WinningLottoTest : FunSpec({

    test("로또 보너스 숫자는 로또 숫자와 중복될 수 없습니다.") {
        shouldThrow<DuplicateLottoNumberException> {
            WinningLotto.of(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoNumber.of(1))
        }
    }

    test("로또 숫자 일치 개수에 따라 순위가 정해진다.") {
        forAll(
            row(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
            row(LottoNumbers.of(1, 2, 3, 4, 5, 45), LottoRank.SECOND),
            row(LottoNumbers.of(1, 2, 3, 4, 5, 16), LottoRank.THIRD),
            row(LottoNumbers.of(1, 2, 3, 4, 15, 16), LottoRank.FOURTH),
            row(LottoNumbers.of(1, 2, 3, 14, 15, 16), LottoRank.FIFTH),
            row(LottoNumbers.of(1, 2, 13, 14, 15, 16), LottoRank.NONE),
            row(LottoNumbers.of(1, 12, 13, 14, 15, 16), LottoRank.NONE),
            row(LottoNumbers.of(11, 12, 13, 14, 15, 16), LottoRank.NONE),
        ) {
            lottoNumbers: LottoNumbers, lottoRank: LottoRank ->
            val winningLotto = WinningLotto.of(LottoNumbers.of(1, 2, 3, 4, 5, 6), LottoNumber.of(45))
            winningLotto.match(Lotto.of(lottoNumbers)) shouldBe lottoRank
        }
    }
})
