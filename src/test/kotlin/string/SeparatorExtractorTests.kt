package string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * 생각의 흐름
 * 기능요구사항에 따라서, 일단 (1)번인 '기본 구분자를 사용하는지 검증한다' 라는 단위를 테스트하려고한다
 * 그런데, 결국에는 입력값을 구분자를 기준으로 분리해주는 책임을 가지는 객체가 필요할 것이고
 * 그 객체의 내부 로직에서 기본 구분자를 사용하는지, 커스텀 구분자를 사용하는지 판단해서 분리해줄수있으니
 * 굳이 이것을 구분하는 객체가 별도로 있어야하나?..
 *
 * 하지만 구분하는 객체가 별도로 있고, 이 구분하는 객체와 나누는 객체가 각자 책임을 갖고 협력하는것도 좋을듯하다
 * 정확히는 기본 구분자를 사용하는지, 커스텀 구분자를 사용하는지 나누는것이 아니라
 * 구분자가 무엇인지 반환하는 객체면 좋을듯
 */
class SeparatorExtractorTests : StringSpec ({
    "기본 구분자 (컴마, 콜론) 를 사용하는지 검증한다" {
        val separatorExtractor = SeparatorExtractor()
        val input = "1,2,3"
        val separator = separatorExtractor.extract(input)
        separator shouldBe ","
    }
})