class Numbers(private val numbers: List<Int>) {

    fun sum(): Int {
        var result = 0
        for (element in numbers) {
            result = result.plus(element)
        }
        return result
    }
}
