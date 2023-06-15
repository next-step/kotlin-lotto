package calculator

object Parser {

    fun parse(input: String?):List<Int> {
        if(input.isNullOrBlank()) return listOf(0)

        return input.split(",",":")
            .map { it.toInt() }
    }




}
