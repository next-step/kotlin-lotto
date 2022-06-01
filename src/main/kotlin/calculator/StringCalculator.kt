package calculator

class StringCalculator {
    fun add(text: String): Int {
        if (text.isEmpty()) {
            return 0
        }

        if (text.toIntOrNull() != null) {
            return text.toInt()
        }

        var delimiter = "[,:]"
        var _text = text

        if (text.startsWith("//")) {
            val result = Regex("//(.)\n(.*)").find(text)
            result?.let { it ->
                require(it.groupValues[1].toIntOrNull() == null) { "구분자는 숫자로 지정할 수 없습니다." }
                delimiter = it.groupValues[1]
                _text = it.groupValues[2]
            }
        }

        return _text
            .split(delimiter.toRegex())
            .sumOf {
                val number = it.toIntOrNull()
                    ?: throw IllegalArgumentException("계산할 값은 정수로 입력해야합니다. text: $text")
                require(number >= 0) { "음수는 계산이 불가능합니다. 0이상의 정수를 입력해주세요.  text: $text" }
                number
            }
    }
}
