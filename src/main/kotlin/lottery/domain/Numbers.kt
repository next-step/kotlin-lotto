package lottery.domain

class Numbers(val numbers: List<List<Int>>) : List<List<Int>> by numbers {
    fun merge(inputNumbers: Numbers): Numbers {
        return Numbers(numbers.plus(inputNumbers))
    }
}
