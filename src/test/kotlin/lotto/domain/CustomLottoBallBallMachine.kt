package lotto.domain

class CustomLottoBallBallMachine(lineValues: List<List<Int>>) : LottoBallMachine {
    private val lottoLines: MutableList<LottoLine> =
        lineValues.map { numbers ->
            LottoLine(numbers.map { LottoBall(it) }.toList())
        }.toMutableList()

    override fun generate(): LottoLine {
        return lottoLines.removeFirst()
    }
}
