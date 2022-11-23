package stringPlusCalculator

class StringInputConverter {
    companion object {
        fun convert(stringOperands: List<String>): List<Int> {
            return stringOperands.map { stringOperand ->
                val intOperand = stringOperand.toInt()
                if (intOperand < 0) throw RuntimeException("음수 값은 변환할 수 없습니다.")

                intOperand
            }
        }
    }
}
