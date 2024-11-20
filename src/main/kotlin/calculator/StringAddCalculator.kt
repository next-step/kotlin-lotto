package calculator

class StringAddCalculator {
    fun add(text: String?): Int {
        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환
        if (text.isNullOrEmpty()) {
            return 0
        }

        try {
            // 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환
            val number = text.toInt()
            if (number < 0) {
                throw RuntimeException("문자열 계산기는 음수를 처리할 수 없다.")
            }

            return number
        } catch (_: NumberFormatException) {
            //  "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다
            val result = Regex("//(.)\n(.*)").find(text)
            result?.let {
                val customDelimiter = it.groupValues[1]
                val numbers = it.groupValues[2].split(customDelimiter)
                if (numbers.stream().anyMatch { number -> number.toInt() < 0 }) {
                    throw RuntimeException("문자열 계산기는 음수를 처리할 수 없다.")
                }
                return numbers.sumOf { number -> number.toInt() }
            }

            // 컴마(,) 혹은 콜론(:)을 구분자로 여러개의 문자를 보낸 경우  해당 숫자의 합을 반환
            val numbers = text.split("[,:]".toRegex())
            if (numbers.stream().anyMatch { number -> number.toInt() < 0 }) {
                throw RuntimeException("문자열 계산기는 음수를 처리할 수 없다.")
            }

            return numbers.sumOf { number -> number.toInt() }
        }
    }
}
