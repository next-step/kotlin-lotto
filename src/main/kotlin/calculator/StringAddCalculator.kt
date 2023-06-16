package calculator


object StringAddCalculator {
    fun calculate(input: String): Int {
        if(input.isEmpty()) {
           return 0
        }
        val tokens = input.split(Regex(pattern = """[,:]""")).map (String::toInt)

        return tokens.sum()
    }
}

