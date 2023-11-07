package study

import io.kotest.core.spec.style.StringSpec

class StudyInlineValueClass : StringSpec({

    "InlineValueClass 의 정의와 선언" {
        println("참고 : https://kotlinlang.org/docs/inline-classes.html")

        val password = Password("i am password")
        println("인라인 클래스는 이렇게 보임 [$password]")
        println("런타임에 실제로 실체화(instantiation)가 일어나지 않음")// No actual instantiation of class 'Password' happens
        println("런타임에는 그냥 String 임") // At runtime 'securePassword' contains just 'String'
        """
        그래서 이름이 "인라인" 인게 코드에서만 클래스처럼 동작하고, 실제로는 기본타입임
        클래스의 데이터는 사용시 인라인 됨
        ( 인라인 함수 의 내용이 사이트를 호출하기 위해 인라인되는 방식과 유사함)
        """.trimIndent()
    }

    "인라인 벨류 클래스의 사용법" {
        val name1 = Person("Kotlin", "Mascot")
        val name2 = Person("Kodee")
        name1.greet() // the `greet()` function is called as a static method
        println(name2.length) // property getter is called as a static method
    }

    "인터페이스 상속이 가능한 인라인 벨류 오브젝트" {
        val name = Name("Kotlin")
        println(name.prettyPrint()) // Still called as a static method
    }

    "표현" {
        """
            생성된 코드에서 Kotlin 컴파일러는 각 인라인 클래스에 대한 래퍼를 유지합니다. 
            인라인 클래스 인스턴스는 런타임 시 래퍼 또는 기본 유형으로 표시될 수 있습니다. 
            이는 기본 요소 또는 래퍼로 표현Int 되는 방법과 유사합니다 .int ->> Integer
            Kotlin 컴파일러는 가장 성능이 뛰어나고 최적화된 코드를 생성하기 위해 래퍼 대신 기본 유형을 사용하는 것을 선호합니다. 
            그러나 때로는 래퍼를 보관해야 하는 경우도 있습니다. 경험상 인라인 클래스는 다른 유형으로 사용될 때마다 boxing됩니다.
        """.trimIndent()
        val f = Fan(42)
        asInline(f)    // unboxed: used as Foo itself
        asGeneric(f)   // boxed: used as generic type T
        asInterface(f) // boxed: used as type I
        asNullable(f)  // boxed: used as Foo?, which is different from Foo
    }

    "참조 동일성" {
        """
            인라인 클래스는 기본 값과 래퍼로 모두 표현될 수 있으므로 참조 동일성은 의미가 없으므로 금지됩니다.

            인라인 클래스는 기본 유형으로 일반 유형 매개변수를 가질 수도 있습니다. 
            이 경우 컴파일러는 이를 Any?유형 매개변수의 상한에 또는 일반적으로 매핑합니다.
            
        """.trimIndent()
        // below, 'f' first is boxed (while being passed to 'id') and then unboxed (when returned from 'id')
        // In the end, 'c' contains unboxed representation (just '42'), as 'f'
        val f = Fan(42)
        println("실행결과 : [${f.action()}] / $f")
        val c = id(f)
        println("실행결과 : [${c.action()}] / $c")
    }
})


@JvmInline
value class Password(private val value: String)


@JvmInline
value class Person(private val fullName: String) {
    init {
        require(fullName.isNotEmpty()) {
            "Full name shouldn't be empty"
        }
    }

    constructor(firstName: String, lastName: String) : this("$firstName $lastName")

    val length: Int
        get() = fullName.length

    fun greet() {
        println("Hello, $fullName")
    }
}




interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}


interface Gear {
    fun action() : String
}

@JvmInline
value class Fan(val i: Int) : Gear {
    override fun action(): String {
        return "바람이 $i 속도로 분다 "
    }
}

fun asInline(fan: Fan) {}
fun <Gear> asGeneric(x: Gear) {}
fun asInterface(gear: Gear) {}
fun asNullable(fan: Fan) {}
fun <T> id(x: T): T = x


//----


@JvmInline
value class UserId<T>(val value: T)
fun compute(s: UserId<String>) {} // compiler generates fun compute-<hashcode>(s: Any?)

