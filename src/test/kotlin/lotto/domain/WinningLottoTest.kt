package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContain
import lotto.domain.vo.LottoNumber

class WinningLottoTest : StringSpec({
    "당첨 로또를 생성할 수 있다" {
        shouldNotThrow<Throwable> { WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7) }
    }

    "로또 번호와 보너스 번호가 중복되는 경우 Exception을 던진다" {
        shouldThrow<IllegalArgumentException> { WinningLotto(listOf(1, 2, 3, 4, 5, 6), 1) }
    }

    "6개 번호가 일치하는 경우 SIX_MATCH를 반환한다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain MatchType.SIX_MATCH
    }

    "5개 번호와 보너스 번호가 일치하는 경우 FIVE_AND_BONUS_MATCH를 반환한다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(45)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain MatchType.FIVE_AND_BONUS_MATCH
    }

    "5개 번호가 일치하는 경우 FIVE_MATCH를 반환한다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(7)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain MatchType.FIVE_MATCH
    }

    "4개 번호가 일치하는 경우 FOUR_MATCH를 반환한다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(7),
            LottoNumber(8)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain MatchType.FOUR_MATCH
    }

    "3개 번호가 일치하는 경우 THREE_MATCH를 반환한다." {
        val lottoNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(7),
            LottoNumber(8),
            LottoNumber(9)
        )

        val lottoBundle = LottoBundle(listOf(Lotto(lottoNumbers)))

        winningLotto.match(lottoBundle) shouldContain MatchType.THREE_MATCH
    }

    "2개 이하의 번호가 일치하는 경우 NONE_MATCH를 반환한다." {
        val lottoNumbers = listOf(
            setOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(10),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9)
            ),
            setOf(
                LottoNumber(1),
                LottoNumber(11),
                LottoNumber(10),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9)
            ),
            setOf(
                LottoNumber(12),
                LottoNumber(11),
                LottoNumber(10),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9)
            )
        )

        lottoNumbers.forAll {
            val lottoBundle = LottoBundle(listOf(Lotto(it)))

            winningLotto.match(lottoBundle) shouldContain MatchType.NONE_MATCH
        }
    }
}) {
    companion object {
        private val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)
    }
}
