package calculator

const val ENTER_TEXT_TO_CALCULATE = "\"계산할 내용을 입력해주세요. (예) 1,2,3 또는 1:2:3  (* 커스텀 구분자 관련 : c 입력)\""
const val CUSTOM_DELIMITER_INFO = "커스텀 구분자 : // 와 \\n 사이에 입력 => (예) //;\\n1;2;3 "
const val NEED_INFO_KEYWORD = "c"

fun main() {

    ENTER_TEXT_TO_CALCULATE.also(::println)

    var text = readLine()

    if (text.equals(NEED_INFO_KEYWORD)) {
        CUSTOM_DELIMITER_INFO.also(::println)
        text = readLine()
    }

    val calculator = StringAddCalculator()
    calculator.add(text).also(::println)
}
