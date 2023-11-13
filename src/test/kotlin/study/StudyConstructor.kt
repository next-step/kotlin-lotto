package study

import io.kotest.core.spec.style.StringSpec

class StudyConstructor : StringSpec({
    "가변 컬렉션은 외부에서의 변경에 취약함을 학습하낟" {
        val linkedHashSet = LinkedHashSet(listOf("1", "2", "3"))
        val f = Foo(linkedHashSet)
        println("before $linkedHashSet")
        linkedHashSet.add("hello")
        println("after $linkedHashSet")
        println("afterManipulation ${f.insideData()}")
    }

    "부 생성자로 취약점을 방어한다" {

    }
})

@JvmInline
value class Foo(
    private val data: LinkedHashSet<String>,
) {
    //    constructor(data: LinkedHashSet<String>) : this(data) //이건 컴파일 에러가 뜬다
    constructor(listData: List<String>) : this(LinkedHashSet(listData))

    fun insideData(): String {
        return data.toString()

    }
}
