package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또는 6개의 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(4) }
    }

    "로또는 중복되지 않은 숫자로 구성되어 있지 않으면 예외를 던진다." {
        shouldThrow<IllegalArgumentException> { FakeLottoGenerator().generate(6) }
    }

    "match()는 인자로 들어온 번호와 로또의 번호가 일치하는 개수를 비교하고 등수를 반환한다." {
        val lotto = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))
        val winLotto = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))

        val rankFirst = lotto.match(winLotto)

        rankFirst shouldBe LottoRank.FIRST

        val lotto2 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))
        val winLotto2 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(7)))

        val rankSecond = lotto2.match(winLotto2)

        rankSecond shouldBe LottoRank.SECOND

        val lotto3 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))
        val winLotto3 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(7), Number(8)))

        val rankThird = lotto3.match(winLotto3)

        rankThird shouldBe LottoRank.THIRD

        val lotto4 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))
        val winLotto4 = Lotto(listOf(Number(1), Number(2), Number(3), Number(7), Number(8), Number(9)))

        val rankFourth = lotto4.match(winLotto4)

        rankFourth shouldBe LottoRank.FOURTH

        val lotto5 = Lotto(listOf(Number(1), Number(2), Number(3), Number(4), Number(5), Number(6)))
        val winLotto5 = Lotto(listOf(Number(1), Number(2), Number(7), Number(8), Number(9), Number(10)))

        val rankNone = lotto5.match(winLotto5)

        rankNone shouldBe LottoRank.NONE
    }
})
