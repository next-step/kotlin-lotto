package stringcalculator

class Number(val value: Int) {
    init {
        require(value >= 0) { "문자열 계산기에는 0, 양수만 인자로 올 수 있습니다!" }
    }

    constructor(valueString: String) : this(valueString.toInt())
}
