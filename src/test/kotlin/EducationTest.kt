import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class EducationTest : StringSpec({
    "정규식 정상 매칭 테스트" {
        val 커스텀구분자 = Regex("^//(.*?)\n").find("//히히\n1히히2히히3")?.groupValues?.get(1)
        커스텀구분자 shouldBe "히히"
    }

    "정규식 아무값 없을때 매칭 테스트" {
        val 커스텀구분자 = Regex("^//(.*?)\n").find("//\n1히히2히히3")?.groupValues?.get(1)
        커스텀구분자 shouldBe ""
    }

    "정규식 빈스트링 들어갔을떄 매칭 테스트" {
        val 커스텀구분자 = Regex("^//(.*?)\n").find("//   \n1히히2히히3")?.groupValues?.get(1)
        커스텀구분자 shouldBe "   "
    }

    "정규식 postfix가 없을때 매칭 테스트" {
        val 커스텀구분자 = Regex("^//(.*?)\n").find("//   1히히2히히3")?.groupValues?.get(1)
        커스텀구분자 shouldBe null
    }
})
