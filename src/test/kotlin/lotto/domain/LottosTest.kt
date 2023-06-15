package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.fixture.createLottoNumbers
import lotto.fixture.of

class LottosTest : FunSpec({

    test("당첨 번호 객체를 전달하면 당첨 통계 정보를 반환한다.") {
        val winningNumber = WinningInfo(createLottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber = LottoNumber.valueOf(20))
        val lottos = listOf(
            Lotto.of(1, 2, 3, 4, 5, 6), /*6개 일치*/
            Lotto.of(1, 2, 3, 4, 5, 6), /*6개 일치*/
            Lotto.of(1, 2, 3, 4, 5, 20), /*5개 일치 보너스 일치*/
            Lotto.of(1, 2, 3, 4, 5, 9), /*5개 일치 보너스 불일치*/
            Lotto.of(1, 2, 7, 8, 5, 6), /*4개 일치*/
            Lotto.of(1, 2, 3, 9, 10, 11), /*3개 일치*/
            Lotto.of(1, 2, 8, 9, 10, 20), /*2개 일치*/
            Lotto.of(1, 7, 8, 9, 10, 20), /*1개 일치*/
            Lotto.of(44, 40, 8, 9, 10, 20) /*0개 일치*/
        ).let(::Lottos)

        val actual = lottos.winningStatistics(winningNumber)

        actual[Rank.FIRST] shouldBe 2
        actual[Rank.SECOND] shouldBe 1
        actual[Rank.THIRD] shouldBe 1
        actual[Rank.FOURTH] shouldBe 1
        actual[Rank.FIVE] shouldBe 1
        actual[Rank.MISS] shouldBe 3
    }

    test("로또 일급 컬렉션끼리 병합할 수 있다.") {
        val source = listOf(
            Lotto.of(1, 2, 3, 4, 5, 6),
            Lotto.of(1, 2, 3, 4, 5, 6),
            Lotto.of(1, 2, 3, 4, 5, 20),
            Lotto.of(1, 2, 3, 4, 5, 9)
        ).let(::Lottos)
        val target = listOf(
            Lotto.of(1, 2, 7, 8, 5, 6),
            Lotto.of(1, 2, 3, 9, 10, 11),
            Lotto.of(1, 2, 8, 9, 10, 20),
            Lotto.of(1, 7, 8, 9, 10, 20),
            Lotto.of(44, 40, 8, 9, 10, 20)
        ).let(::Lottos)

        val actual = source.merge(target)

        actual shouldHaveSize source.size + target.size
    }
})
