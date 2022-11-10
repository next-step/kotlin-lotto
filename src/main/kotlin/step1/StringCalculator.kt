package step1

class StringCalculator {
    companion object {
        private val DEFAULT_SEPARATOR = "[,:]".toRegex()
        fun calculate(input: String?): Int {
            if(input.isNullOrEmpty()) return 0


            return input.split(DEFAULT_SEPARATOR)
                .sumOf { it.toInt() }
        }
    }


}