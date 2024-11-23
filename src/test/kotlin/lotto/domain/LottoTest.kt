package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.fixture.createLottoFixture

class LottoTest : StringSpec({
    "로또는 6개의 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(4) }
    }

    "로또는 중복되지 않은 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(6) }
    }

    "match()는 인자로 들어온 번호와 로또의 번호가 일치하는 개수를 비교하고 등수를 반환한다." {
        val lotto = createLottoFixture(listOf(1, 2, 3, 4, 5, 6))
        val winLotto = createLottoFixture(listOf(1, 2, 3, 4, 5, 6))
        val rankFirst = lotto.match(winLotto)

        rankFirst shouldBe LottoRank.FIRST

        val winLotto2 = createLottoFixture(listOf(1, 2, 3, 4, 5, 7))
        val rankSecond = lotto.match(winLotto2)

        rankSecond shouldBe LottoRank.SECOND

        val winLotto3 = createLottoFixture(listOf(1, 2, 3, 4, 7, 8))
        val rankThird = lotto.match(winLotto3)

        rankThird shouldBe LottoRank.THIRD

        val winLotto4 = createLottoFixture(listOf(1, 2, 3, 7, 8, 9))
        val rankFourth = lotto.match(winLotto4)

        rankFourth shouldBe LottoRank.FOURTH

        val winLotto5 = createLottoFixture(listOf(1, 2, 7, 8, 9, 10))
        val rankNone = lotto.match(winLotto5)

        rankNone shouldBe LottoRank.NONE
    }
})
