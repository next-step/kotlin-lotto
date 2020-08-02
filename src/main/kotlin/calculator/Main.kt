package calculator

const val ENTER_TEXT_TO_CALCULATE = "계산할 내용을 입력해주세요. (예) 1,2,3 또는 1:2:3  (* 커스텀 구분자 관련 : c 입력)"
const val CUSTOM_DELIMITER_INFO = "커스텀 구분자 : // 와 \\n 사이에 입력 => (예) //;\\n1;2;3 "
const val NEED_INFO_KEY = "c"
const val ALERT_ZERO_OR_EMPTY_INPUT = "입력값이 0이거나 비어있습니다. "

fun main() {
    var result = 0

    while (result == 0) {
        println(ENTER_TEXT_TO_CALCULATE)
        var text = readLine()

        if (text.equals(NEED_INFO_KEY)) {
            println(CUSTOM_DELIMITER_INFO)
            text = readLine()
        }

        result = StringAddCalculator.add(text)
        if (result == 0) println(ALERT_ZERO_OR_EMPTY_INPUT)
    }
    println(result)
}
