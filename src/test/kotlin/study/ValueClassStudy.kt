package study

import lotto.domain.LottoNumber

fun main1() {
    val lottoNumber = LottoNumber(1)

    // 생성자로 생성할땐 어떻게 될까
    val duration = Duration(1000)
    println("duration = $duration")

    // Companion object를 이용해 생성할 땐 어떻게 될까
    val millis = Duration.millis(1000)
    val millis2 = Duration.millis("1000")
    val seconds = Duration.seconds(1)
    println("Millis=${millis}, seconds=${seconds}")

    // value class를 파라미터로 받는 함수는 어떻게 될까
    reserveAlarm("으아악 아침이다", duration)
}

fun reserveAlarm(alarmMessage: String, duration: Duration) =
    println("$duration.millis millis 후에 [$alarmMessage] 알람이 울립니다.")


class Person {
    fun doSomething() {}
    fun doSomething(value: String) {}
    fun doSomething(value: Int) {}
}

fun compute(s: UserId<String>) {}  // UserId<String> = Any 취급
fun compute(s: List<String>) {}  // 원래의 제네릭 처럼 <String>만 사라짐

@JvmInline
value class UInt(val x: Int)

// Represented as 'public final void compute(int x)' on the JVM
fun compute(x: Int) { }

// Also represented as 'public final void compute(int x)' on the JVM!
fun compute(x: UInt) { }

typealias NameTypeAlias = String

@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main() {
    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias) // OK: pass alias instead of underlying type
//    acceptString(nameInlineClass) // Not OK: can't pass inline class instead of underlying type

    // And vice versa:
    acceptNameTypeAlias(string) // OK: pass underlying type instead of alias
//    acceptNameInlineClass(string) // Not OK: can't pass underlying type instead of inline class
}