package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumber

class Associate : DescribeSpec({
    describe("associateWith") {
        context(" 컬렉션의 각 요소를 키로 하고, 주어진 변환 함수(valueSelector)를 사용해 값을 생성하여 Map을 만드는 데 사용") {
            it("test1") {
                val words = listOf("a", "abc", "ab", "def", "abcd")

                val associateWith: Map<String, Int> = words.associateWith { it.length }

                associateWith["a"] shouldBe 1
                associateWith["abc"] shouldBe 3
                associateWith["ab"] shouldBe 2
                associateWith["def"] shouldBe 3
                associateWith["abcd"] shouldBe 4
            }

            it("test2") {
                val words = listOf(1, 2, 3, 4, 5)

                val associateWith: Map<Int, Int> = words.associateWith { it * it }

                associateWith[1] shouldBe 1
                associateWith[2] shouldBe 4
                associateWith[3] shouldBe 9
                associateWith[4] shouldBe 16
                associateWith[5] shouldBe 25
            }
        }
    }

    describe("associate") {
        context("람다에서 Map의 키도 생성") {
            it("test1") {
                val words = listOf("a", "abc", "ab", "def", "abcd")

                val associate: Map<String, Int> = words.associate { it to it.length }

                associate["a"] shouldBe 1
                associate["abc"] shouldBe 3
                associate["ab"] shouldBe 2
                associate["def"] shouldBe 3
                associate["abcd"] shouldBe 4
            }
        }

        context("key가 중복이면 마지막 el 저장") {
            it("test1") {
                val words = listOf("a", "abc", "ab", "abcd")

                val associate: Map<String, String> = words.associate { it.first().toString() to it }

                associate.size shouldBe 1
                associate["a"] shouldBe "abcd"
            }
        }
    }

    describe("groupBy") {
        context("키가 중복이면 value에 리스트로 저장") {
            it("test1") {
                val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

                val groupBy = numbers.groupBy { it % 2 }

                groupBy[0] shouldBe listOf(2, 4, 6, 8)
                groupBy[1] shouldBe listOf(1, 3, 5, 7, 9)
            }
        }
    }

    describe("LottoNumber with associateWith") {
        it("test") {
            val numbers: Map<Int, LottoNumber> = (1..45).associateWith(::LottoNumber)
            numbers[1] shouldBe LottoNumber(1)
            numbers[2] shouldBe LottoNumber(2)
            numbers[3] shouldBe LottoNumber(3)
            numbers[4] shouldBe LottoNumber(4)
        }
    }
})
