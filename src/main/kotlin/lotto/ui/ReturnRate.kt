package lotto.ui

class ReturnRate(private val rate: Double) : UI {
    override fun draw() {
        println("총 수익률은 ${this.rate}입니다.")
    }
}
