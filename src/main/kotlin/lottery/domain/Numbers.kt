package lottery.domain

class Numbers(val numbers: List<LotteryNumbers>) : List<LotteryNumbers> by numbers {
    fun merge(inputNumbers: Numbers): Numbers {
        return Numbers(numbers + inputNumbers)
    }
}
