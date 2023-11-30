package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import lotto.domain.model.vo.LottoNumber
import lotto.domain.model.vo.LottoNumbers

/**
 * 로또 번호 리스트 테스트
 * */
class LottoNumberListTest : FunSpec({

    test("번호 리스트 생성시 []을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers.valueOf(setOf())
        }
    }

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 5]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 5))
        }
    }

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6, 7]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    test("로또 번호 리스트 생성시 [0, 2, 3, 4, 5, 6]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers.valueOf(setOf(0, 2, 3, 4, 5, 6))
        }
    }

    test("로또 번호 리스트 생성시 [41, 42, 43, 44, 45, 46]을 넣을 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            LottoNumbers.valueOf(setOf(41, 42, 43, 44, 45, 46))
        }
    }

    test("로또 번호 리스트 생성시 [1, 2, 3, 4, 5, 6]을 넣을 경우 [1, 2, 3, 4, 5, 6]을 가지고 있는 로또 번호 리스트가 생성 되어야 한다.") {
        val lottoNumbers = LottoNumbers.valueOf(setOf(1, 2, 3, 4, 5, 6))

        val mutableSet = mutableSetOf<LottoNumber>()
        (1..6).forEach { index ->
            mutableSet.add(LottoNumber.valueOf(index))
        }

        lottoNumbers.value shouldContainExactly mutableSet.toSet()
    }
})
