package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoFactoryTest : FunSpec({
    test("로또 생성기는 6개의 숫자를 골라 로또 한 장을 생성한다.") {
        val lottoList = LottoFactory.generateLottoList(1).first()
        lottoList.value.size shouldBe 6
    }


    test("로또 생성기가 고른 숫자는 1 ~ 45 숫자이다.") {
        val lottoList = LottoFactory.generateLottoList(1).first()
        lottoList.value.forAll { it shouldBeInRange (1..45) }
    }

    test("로또 생성기는 숫자 N을 입력받아 N개의 로또를 생성한다.") {
        val lottoList = LottoFactory.generateLottoList(10)
        lottoList.size shouldBe 10
    }
})
