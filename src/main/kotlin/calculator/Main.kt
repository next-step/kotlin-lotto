package calculator

fun main() {

    println("계산할 내용을 입력해주세요. (예) 1,2,3 또는 1:2:3  (* 커스텀 구분자 관련 : c 입력)")
    var text = readLine()

    if (text.equals("c")) {
        println("커스텀 구분자 : // 와 \\n 사이에 입력 => (예) //;\\n1;2;3 ")
        text = readLine()
    }

    val calculator = StringAddCalculator()
    calculator.add(text).also(::println)
}
