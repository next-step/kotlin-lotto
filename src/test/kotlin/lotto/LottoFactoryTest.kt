package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.domain.generateLottoList

class LottoFactoryTest : FunSpec({
    test("로또 생성기는 6개의 숫자를 골라 로또 한 장을 생성한다.") {
        val lotto = generateLottoList().first()
        lotto.numbers.size shouldBe 6
    }


    test("로또 생성기가 고른 숫자는 1 ~ 45 숫자이다.") {
        val lotto = generateLottoList().first()
        lotto.numbers.forAll { it shouldBeInRange (1..45) }
    }

    test("로또 생성기는 숫자 N을 입력받아 N개의 로또를 생성한다.") {
        val lottoList = generateLottoList(10)
        lottoList.size shouldBe 10
    }
})