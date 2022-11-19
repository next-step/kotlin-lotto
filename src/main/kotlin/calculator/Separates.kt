package calculator

data class Separates(val value: List<String>){
    fun toIntList(): List<Int> {
        if(hasValidNumber()){
            throw RuntimeException("숫자가 아닌 값은 입력될 수 없습니다.")
        }

        return value.map{
                number -> number.toInt()
        }
    }

    private fun hasValidNumber() = value.any { number -> number.toIntOrNull() === null }

    companion object{
        fun parse(text: String): Separates {
            return Separates(separateByDelimiter(text))
        }

        private fun separateByDelimiter(text: String): List<String> {
            val result = Regex("//(.)\n(.*)").find(text)
            result?.let {
                val customDelimiter = it.groupValues[1]

                return it.groupValues[2]
                    .split(customDelimiter)
            }

            return text.split("[,:]".toRegex())
        }
    }
}
