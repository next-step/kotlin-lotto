package string.addition.caculator.ui

import string.addition.caculator.application.OperandParser
import string.addition.caculator.domain.Operand

object StringInputView {

    fun getStrings(): List<Operand> {
        println("덧셈할 숫자들을 입력하세요.")
        println("--기본 구분자: [,:] ex. 1:3:1")
        println("--커스텀 구분자는 // 와 \\n 사이에 입력한다 ex. //?\\n1?3?1")
        print(">>>")
        val inputStr = readln().replace(" ", "")
        return OperandParser.parse(inputStr)
    }
}
