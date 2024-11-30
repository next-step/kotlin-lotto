package study

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.BeforeTest
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldHaveLength

class KotestStudyTest : FunSpec({
    test("1 + 2는 3이다") {
        1 + 2 shouldBe 3
    }
})

class NestedTest : DescribeSpec({
    describe("Junit의 @Nested 같은 느낌") {
        it("내부 테스트 1") {
            1 + 2 shouldBe 3
        }

        it("내부 테스트 2") {
            2 + 2 shouldNotBe 3
        }
    }
})

/**
 * `@ParameterizedTest` 의 대안재로 쓸 수 있을듯 함
 *
 * 아래와 똑같이 동작
 * ```kotlin
 * class DynamicTests : FunSpec({
 *
 *    test("sam 의 길이는 3이다") {
 *       "sam" shouldHaveLength 3
 *    }
 *
 *    test("pam 의 길이는 3이다") {
 *       "pam" shouldHaveLength 3
 *    }
 *
 *    test("tim 의 길이는 3이다") {
 *      "tim" shouldHaveLength 3
 *    }
 * })
 * ```
 */
class DynamicTests : FunSpec({
    listOf("sam", "pam", "tim").forEach {
        test("$it 의 길이는 3이다") {
            it shouldHaveLength 3
        }
    }
})


// 외부에 선언..? 더알아보자
val database = mutableMapOf<Long, String>()

class Callbacks : FunSpec({
    beforeEach {
        database.clear()  // 이런식으로 접근해서 DB 리셋하는 것 처럼 사용하나?

        println("===테스트 시작===")
        println("""
            [it 알아보기] 
            it = $it
            it.test = ${it.test}
            it.spec = ${it.spec}
            => 그런데 이거 어디다쓸까? 직접 사용할 일은 없을 것 같다. 
               그냥 내부에서 test 코드 접근 전에 실행할 장치같은 것 같음.(TestListener)  
        """.trimIndent())
    }

    test("Kotest의 길이는 6이다") {
        "Kotest" shouldHaveLength 6
    }

    test("테스트가 두개면 어떻게되지") {
        "kim" shouldHaveLength 3
    }

//    test("테스트가 여러갠데 하나가 실패하면 어떻게되지") {
//        "kim" shouldHaveLength 100  // 그냥 독립적인 테스트
//    }

    afterEach {
        println("===테스트 끝===")
    }
})

val resetDatabase: BeforeTest = {
    database.clear()
}

class ReusableCallbacks : FunSpec({

    beforeTest(resetDatabase)

    test("데이터베이스가 truncate 되고 나서 아래의 로직 수행!") {
        database shouldBe emptyMap()
    }
})

/**
 * Kotest에는 여러 종류의 스펙이 있는데, 가장 접하기 쉬운 것이 String spec이라고 한다.
 * - [공식 문서](https://kotest.io/docs/framework/testing-styles.html#string-spec)
 *
 * 다양한 스펙이 있으니, 참고하면 좋을 것 같다. 아마 테스트 스타일 차이일듯? String spec을 먼저 써보자
 */
class StringSpecTest : StringSpec({
   "String spec은 함수 없이 작성이 가능해서 많이 애용하는 것 같다" {
       "정말간결한것 같음" shouldHaveLength 9
   }
})

class FreeSpecTest : FreeSpec({
    "FreeSpec은 이렇게도 쓴다" - {
        "마지막 검증 메서드에는 -를 붙이면 안됨" {
            "굿" shouldHaveLength 1
        }
    }

    "assertSoftly로 한번에 검증하기" {
        assertSoftly {
            "Hello" shouldBe "World" // 이 검증은 실패
            1 + 1 shouldBe 2
            listOf(1, 2, 3) shouldContain 4 // 이 검증도 실패
        }
    }
})