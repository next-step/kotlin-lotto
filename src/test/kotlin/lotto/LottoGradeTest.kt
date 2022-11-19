package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoGradeTest : StringSpec({
    "로또 등급은 당천 번호 객수로 찾으면 해당하는 등급을 반환한다" {
        listOf(
            0 to LottoGrade.BOOM,
            1 to LottoGrade.BAD_GRADE,
            2 to LottoGrade.UNLUCKY_GRADE,
            3 to LottoGrade.BASIC_GRADE,
            4 to LottoGrade.THIRD_GRADE,
            5 to LottoGrade.SECOND_GRADE,
            6 to LottoGrade.FIST_GRADE
        ).forAll() {
            val (correctNumber, grade) = it
            LottoGrade.find(correctNumber) shouldBe grade
        }
    }
})
